package com.kiun.functionary.base;

import io.micrometer.common.util.StringUtils;
import org.slf4j.event.Level;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.helpers.SubstituteLogger;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryLogger extends SubstituteLogger {

    public static class LogInfo {
        private String message;

        private Date createTime;

        private Level level;

        private String moduleName;

        public LogInfo(String message, Date createTime, Level level, String moduleName) {
            this.message = message;
            this.createTime = createTime;
            this.level = level;
            this.moduleName = moduleName;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }
    }

    private static Map<String, MemoryLogger> memoryLoggerMap = new HashMap<>();

    private Queue<SubstituteLoggingEvent> loggingEvents;

    private MemoryLogger(String moduleName, Queue<SubstituteLoggingEvent> loggingEvents){
        super(moduleName, loggingEvents, false);
        this.loggingEvents = loggingEvents;
    }

    public static MemoryLogger logger(String moduleName){
        MemoryLogger memoryLogger = memoryLoggerMap.get(moduleName);
        if (memoryLogger == null){
            memoryLogger = new MemoryLogger(moduleName, new LinkedList<>());
            memoryLoggerMap.put(moduleName, memoryLogger);
        }
        return memoryLogger;
    }

    public Queue<SubstituteLoggingEvent> getLoggingEvents() {
        return loggingEvents;
    }

    public static List<LogInfo> searchLog(
            String moduleName,
            Level level,
            String searchText,
            Date startTime,
            Date endTime
    ) {
        List<LogInfo> logInfoList = new LinkedList<>();
        memoryLoggerMap.entrySet().stream()
                .filter(item-> StringUtils.isEmpty(moduleName) || item.getKey().contains(moduleName))
                .map(item -> item.getValue().loggingEvents)
                .forEach(loggingEvents -> {
            List<LogInfo> list = loggingEvents.stream()
                    .map(item ->
                            new LogInfo(
                                    MessageFormatter.arrayFormat(item.getMessage(), item.getArgumentArray()).getMessage(),
                                    new Date(item.getTimeStamp()), item.getLevel(), item.getLoggerName()
                            )
                    )
                    .filter(item -> {
                        if (level != null && item.getLevel().toInt() < level.toInt()) {
                            return false;
                        }

                        if (startTime != null && endTime != null) {
                            return item.createTime.after(startTime) && item.createTime.before(endTime);
                        } else if (startTime != null) {
                            return item.createTime.after(startTime);
                        } else if (endTime != null) {
                            return item.createTime.before(endTime);
                        }
                        return !StringUtils.isNotEmpty(searchText) || item.message.contains(searchText);
                    }).collect(Collectors.toList());
            logInfoList.addAll(list);
        });
        return logInfoList;
    }

    public static void clear(String moduleName){
        if (moduleName == null){
            memoryLoggerMap.values().forEach(MemoryLogger::clear);
            return;
        }
        MemoryLogger memoryLogger = memoryLoggerMap.get(moduleName);
        if (memoryLogger != null){
            memoryLogger.clear();
        }
    }

    public void clear(){
        loggingEvents.clear();
    }
}
