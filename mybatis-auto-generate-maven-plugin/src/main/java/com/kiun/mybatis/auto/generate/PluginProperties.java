package com.kiun.mybatis.auto.generate;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                .sorted()
                .filter(item-> item.matches(head + "-\\d$"))
                .map(properties::getProperty).collect(Collectors.toList());
    }

    public List<Map.Entry<String,String>> getEntry(String head) {
        return properties.entrySet().stream()
                .filter(item-> item.getKey().toString().matches(head + "-\\d$"))
                .map(item-> new Entry((String) item.getKey(), (String) item.getValue()))
                .collect(Collectors.toList());
    }

    public List<EntryAndAttribute> getEntryAndAttribute(String head) {
        return properties.entrySet().stream()
                .map(item-> {
                    Matcher matcher = Pattern.compile(head + "-(\\d)(|-[a-zA-Z,]{1,20})$").matcher(item.getKey().toString());
                    if (!matcher.find()){
                        return null;
                    }
                    return new EntryAndAttribute(
                            head + "-" + matcher.group(1),
                            (String) item.getValue(),
                            matcher.group(2).replace("-", ""),
                            Integer.parseInt(matcher.group(1)));
                })
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(EntryAndAttribute::getSort))
                .collect(Collectors.toList());
    }
}
