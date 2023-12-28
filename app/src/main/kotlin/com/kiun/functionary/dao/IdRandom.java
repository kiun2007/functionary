package com.kiun.functionary.dao;


import com.kiun.functionary.service.utils.DateUtil;
import com.kiun.functionary.service.utils.StringUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

public abstract class IdRandom {

    /**
     * 业务-机器代码
     */
    private static String mNo = "1001";

    /**
     * 当前系统时间下一分钟的时间戳
     */
    private static long NEXT_MINUTE_TIMESTAMP = 0L;

    /**
     * 当前系统时间字符串缓存（yyyyMMddHHmm精确到分钟）
     */
    private static String CURRENT_MINUTE_STR = null;

    /**
     * 计数器最大值
     */
    private final static int SEQ_MAX = 99999999;

    /**
     * 计数器最大值的长度
     */
    private final static int SEQ_LENGTH = String.valueOf(SEQ_MAX).length();

    /**
     * 通用流水号计数器
     */
    private static int CURRENT_SEQ = new Random().nextInt(SEQ_MAX/2);

    private String newId;

    public abstract void setId(String id);

    protected abstract String getId();

    private String getCommonID() {
        StringBuffer seqSb = new StringBuffer(32);
        seqSb.append(getTimeStr()); // 时间前缀
        seqSb.append(mNo); // 机器编号
        String seqStr = String.valueOf(this.nextSeq());
        seqStr = StringUtil.leftZero(seqStr, SEQ_LENGTH);
        seqSb.append(seqStr);
        return seqSb.toString();
    }

    public void fillId(){
        setId(newId);
    }

    public String exportId(){
        return getId();
    }

    /**
     * 获取通用流水号的序列
     * @return
     */
    private synchronized int nextSeq() {
        if (++CURRENT_SEQ > SEQ_MAX) {
            CURRENT_SEQ = new Random().nextInt(SEQ_MAX);
        }
        return CURRENT_SEQ;
    }

    /**
     * 获取时间yyyyMMddHHmmss字符串
     * @return
     */
    private String getTimeStr() {

        if (System.currentTimeMillis() >= NEXT_MINUTE_TIMESTAMP) {
            // 生成新的时间字符串及下一分钟的时间戳缓存
            String timeTemp = DateUtil.format("yyyyMMddHHmm");
            CURRENT_MINUTE_STR = timeTemp;
            NEXT_MINUTE_TIMESTAMP = System.currentTimeMillis() - (System.currentTimeMillis() % 6000) + 60000;
        }
        return CURRENT_MINUTE_STR;
    }

    public IdRandom(){
        flushId();
    }


    public void flushId(){
        setId(newId = getCommonID());
    }

    public Date timeOfId(){
        String id = getId();
        if (id != null && id.length() > 12){
            id = id.substring(0,12);
            try {
                return DateUtil.dateFrom("yyyyMMddHHmm", id);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public boolean isNew(){
        if (getId() == null){
            return true;
        }
        return newId.equals(getId());
    }
}
