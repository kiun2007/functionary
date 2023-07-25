package com.kiun.mybatis.auto.generate;

import java.util.HashMap;
import java.util.Map;

public class RuntimeAttribute {

    private Map<String, Object> attri = new HashMap<>();

    public RuntimeAttribute put(String key, Object value){
        attri.put(key, value);
        return this;
    }

    public String run(String exp, boolean isString){
        if (attri.isEmpty()){
            return exp;
        }

        for (Map.Entry<String, Object> item : attri.entrySet()) {
            exp = exp.replaceAll("\\$\\{" + item.getKey() + "}", isString ? String.format("\"%s\"", item.getValue().toString()) : item.getValue().toString());
        }
        return exp;
    }
}
