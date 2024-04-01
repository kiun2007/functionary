package com.kiun.functionary.base;

import org.slf4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消息会话类, 轻量级消息队列, 适用于多线程间的数据传递.
 * 例子:
 * 消费者 {@link MessageSession#await(Long, String, String)}
 * 生产者 {@link MessageSession#push(String, String, Object)}
 */
public class MessageSession {

    private static class Null{
        public static boolean isNull(Object value){
            return value instanceof Null;
        }
    }

    /**
     * 需求键值 map
     */
    private static class NeedMap extends HashMap<Object, Object>{
        /**
         * 数据是否完整.
         * @return 是否完整
         */
        public boolean isComplete(){
            for(Object value : values()){
                if(Null.isNull(value)){
                    return false;
                }
            }
            return true;
        }
    }

    public static class Session{
        private Lock lock;
        private Condition condition;
        private Object value;
        private final Long createTime;

        public Session(Lock lock, Object value) {
            this.lock = lock;
            this.value = value;
            if(lock != null){
                condition = lock.newCondition();
            }
            createTime = System.currentTimeMillis();
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Lock lock() {
            return lock;
        }

        public Lock newLock(){
            return lock = new ReentrantLock();
        }

        public void setLock(Lock lock) {
            this.lock = lock;
        }

        public Condition condition() {
            return condition;
        }

        public boolean await(long count, TimeUnit unit) throws InterruptedException {
//            condition = lock.newCondition();
            return condition.await(count, unit);
        }

        public Long getCreateTime() {
            return createTime;
        }

        @Override
        public String toString() {
            return "[value:"+ value + ", startTime:" + createTime + ", lock: " + lock + "]";
        }
    }

    private static MessageSession selfSession;
    private final Map<String, Session> sessions = new HashMap<>();
    private static final Logger logger = MemoryLogger.logger("MessageSession"); // 日志 LoggerFactory.getLogger(MessageSession.class)

    /**
     * 允许堆积消息.
     */
    private final boolean isPileUp;

    public static MessageSession session(){
        return session(false);
    }

    public static MessageSession session(boolean isPileUp){
        if(selfSession == null){
            selfSession = new MessageSession(isPileUp);
        }
        return selfSession;
    }

    /**
     * 初始化消息会话
     * @param isPileUp 是否允许消息堆叠
     */
    public MessageSession(boolean isPileUp){
        this(isPileUp, -1, -1);
    }

    public long MessageCount(){
        return sessions.size();
    }

    public Map<String, Session> getSessions() {
        return sessions;
    }

    /**
     * 初始化消息会话
     * @param isPileUp 是否允许消息堆叠
     * @param timeOutClean 消息超过指定毫秒后自动清除
     * @param cleanTimer 堆积消息清除周期
     */
    public MessageSession(boolean isPileUp, int timeOutClean, int cleanTimer){

        this.isPileUp = isPileUp;

        if(this.isPileUp){
            if (timeOutClean == -1){
                return;
            }
            //定时清理消费者不领取的消息.
            Runnable cleanRunnable = () -> {

                while (true) {
                    try {
                        Thread.sleep(cleanTimer);
                    } catch (InterruptedException ignored) {
                    }
                    //定时清理消费者不领取的消息.
                    Long now = System.currentTimeMillis();

                    List<String> cleanKeys = new LinkedList<>();
                    for (String key : sessions.keySet()) {
                        Session session = sessions.get(key);
                        if (session.lock == null && (now - session.createTime > timeOutClean)) {
                            cleanKeys.add(key);
                        }
                    }

                    for (String key : cleanKeys) {
                        sessions.remove(key);
                    }
                }
            };
            Thread cleanThread = new Thread(cleanRunnable);
            cleanThread.start();
        }
    }

    /**
     * 等待并接受返回值
     * @param sec 等待最长时间
     * @param type 类型
     * @param id 标识值
     * @param <T> 返回值类型
     * @return 返回值
     * @throws InterruptedException 同步锁发生异常
     */
    public <T> T await(Long sec, String type, String id) throws InterruptedException {
        return await(sec, type, id, null);
    }

    /**
     * 等待并接受返回值
     * @param sec 等待最长时间
     * @param type 类型
     * @param <T> 返回值类型
     * @return 返回值
     * @throws InterruptedException 同步锁发生异常
     */
    public <T> T await(Long sec, String type) throws InterruptedException {
        return await(sec, type, null, null);
    }

    /**
     * 等待并接受返回值
     * @param sec 等待最长时间 单位秒
     * @param type 类型
     * @param id 标识值
     * @param needs 需求值列表
     * @param <T> 返回值类型
     * @return 返回消息值
     * @throws InterruptedException 同步锁发生异常
     */
    public <T> T await(Long sec, String type, String id, Object[] needs) throws InterruptedException {

        Session session;
        String key;
        synchronized(sessions) {

            key = findKey(type, id);
            logger.debug("[消费者] 判断是否需要创建需求session, {}", System.currentTimeMillis());
            if (isPileUp && (session = sessions.get(key)) != null) {
                //消费者区分
                if (session.value != null) {
                    //生产者堆积好了数据,直接取走.
                    sessions.remove(key);
                    logger.debug("[消费者] 存在数据, 此时队列数量{} {}", sessions.size(), System.currentTimeMillis());
                    return (T) session.getValue();
                }
            }
            logger.debug("[消费者] 即将创建需求, {}", System.currentTimeMillis());

            NeedMap needMaps = null; //初始化需求列表.
            if(needs != null){
                needMaps = new NeedMap();
                for(Object need : needs){
                    needMaps.put(need, new Null());
                }
            }

            session = new Session(new ReentrantLock(), needMaps);
            logger.debug("[消费者] 创建需求session, {}", System.currentTimeMillis());
            //需求不可覆盖
            key = String.format("%s:%s", type, UUID.randomUUID().toString().replace("-", ""));
            sessions.put(key, session);

            logger.debug("[消费者] 创建需求完成, {}", key);
            session.lock().lock();
            logger.debug("[消费者] 等待生产者完成, {}", key);
        }
        boolean lockInTime = session.await(sec, TimeUnit.SECONDS);
        session.lock().unlock();
        logger.debug("[消费者] 搜索到 session, {}", System.currentTimeMillis());
        //移除锁防止被反复使用.
        synchronized (sessions) {
            if (lockInTime){
                //未超时,正常返回.
                return (T) session.getValue();
            }
            else
            {
                //超时后需求应该要被删除，过期不候.
                sessions.remove(key);
            }
        }

        //超时返回.
        return null;
    }

    /**
     * 推送消息到指定类型
     * @param type 消息类型
     * @param id 标识
     * @param value 传递值
     * @return 是否推送成功
     */
    public boolean push(String type, String id, Object value){
        return push(type, id, value, null);
    }

    /**
     * 推送消息到指定类型, 不指定标识
     * @param type 消息类型
     * @param value 传递值
     * @return 是否推送成功
     */
    public boolean push(String type, Object value){
        return push(type, UUID.randomUUID().toString().replace("-", ""), value, null);
    }

    /**
     * 推送消息到指定类型
     * @param type 消息类型
     * @param id 标识
     * @param value 传递值
     * @param needKey 填充指定key，若填充的key 满足需求所需的全部key，await结束.
     * @return 是否推送成功
     */
    public boolean push(String type, String id, Object value, Object needKey){

        String key = String.format("%s:%s", type, id);

        Session session;
        logger.debug("[生产者] 检索是否存在需求, 值={}", value);
        synchronized (sessions){
            long lockCount = sessions.entrySet().stream().filter(item-> item.getValue().lock != null).count();
            logger.debug("[生产者] 需求{}个", lockCount);
            session = findSession(type);
            logger.debug("[生产者] 投入 {}, {}========", session, key);

            if(session != null){
                boolean isNeedMap = false;
                if(needKey != null && session.getValue() != null && (isNeedMap = (session.getValue() instanceof NeedMap))) {
                    NeedMap needMap = (NeedMap) session.getValue();
                    needMap.put(needKey, value);
                    if (!needMap.isComplete()){
                        //消息未完成.
                        return true;
                    }
                }

                if (session.lock() != null) {

                    session.lock().lock();
                    logger.debug("[生产者] 锁住 {}, {}", session.condition().hashCode(), System.currentTimeMillis());
                    if (!isNeedMap) {
                        session.setValue(value);
                    }
                    session.condition().signal();
                    logger.debug("[生产者] 解锁 {}", System.currentTimeMillis());
                    session.lock().unlock();
                    Map.Entry<String, Session> find = sessions.entrySet().stream().filter(item-> Objects.equals(item.getValue(), session)).findFirst().orElse(null);
                    if (find != null){
                        sessions.remove(find.getKey());
                    }
                    logger.debug("[生产者] {} 解锁后 sessions = {}", find.getKey(), sessions.size());
                } else{
                    logger.debug("[生产者] 锁不存在");
                    sessions.put(key, new Session(null, value));
                    logger.debug("[生产者] 消息放入队列, {}, size = {}", key, sessions.size());
                }
                return true;
            }else if (isPileUp){
                //允许生产者堆积消息.
                sessions.put(key, new Session(null, value));
                logger.debug("[生产者] 消息放入队列, {}, size = {}", key, sessions.size());
                return true;
            }
        }
        logger.debug("[生产者] 消息丢失, 值={}", value);
        return false;
    }

    private String findKey(String type, String id){
        if (id != null){
            return String.format("%s:%s", type, id);
        }
        return sessions.keySet().stream().findFirst().filter(item-> item.startsWith(type)).orElse(type);
    }

    private Session findSession(String key){

        String orKey = sessions.keySet().stream().findFirst().filter(item-> item.startsWith(key)).orElse(null);
        if (orKey != null){
            return sessions.get(orKey);
        }
        return null;
    }
}
