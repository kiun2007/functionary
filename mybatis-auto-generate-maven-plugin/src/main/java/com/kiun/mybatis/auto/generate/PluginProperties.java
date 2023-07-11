package com.kiun.mybatis.auto.generate;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PluginProperties {

    public static final String CRITERIA_INTERFACE = "criteriaInterface";

    public static final String ClientRoot = "clientRoot";

    private final Properties properties;

    public static class Entry implements Map.Entry<String, String>{

        private String key;

        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            this.value = value;
            return value;
        }
    }

    public PluginProperties(Properties properties){
        this.properties = properties;
    }

    public String criteriaRoot(){
        return properties.getProperty("criteriaRoot");
    }

    public String criterionClass(){
        return properties.getProperty("criterionClass", "");
    }

    public boolean withSetter() {
        return "1".equals(properties.getProperty("withSetter"));
    }

    public String exampleBase(){
        return properties.getProperty("exampleBase");
    }

    public boolean autoAddId(){
        return "1".equals(properties.getProperty("autoAddId"));
    }

    public List<String> getList(String head){
        return properties.keySet().stream()
                .map(item-> (String)item)
                .filter(item-> item.matches(head + "-\\d$"))
                .map(properties::getProperty).collect(Collectors.toList());
    }

    public List<Map.Entry<String,String>> getEntry(String head) {
        return properties.entrySet().stream()
                .filter(item-> item.getKey().toString().matches(head + "-\\d$"))
                .map(item-> new Entry((String) item.getKey(), (String) item.getValue()))
                .collect(Collectors.toList());
    }
}
