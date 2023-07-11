package com.kiun.functionary.service.utils;

public class SqlUtil {

    /**
     * 字符不为空或空字符
     * @param value 判断字符串
     * @return
     */
    public static boolean isNotBlank(String value){
        return value != null && !value.isEmpty();
    }

    /**
     * 全都不为空
     * @param values
     * @return
     */
    public static boolean allNotBlank(String...values){
        for (String value : values){
            if (!isNotBlank(value)){
                return false;
            }
        }
        return true;
    }

    /**
     * 至少一个不为空
     * @param values
     * @return
     */
    public static boolean leastNotBlank(Object ... values){

        for (Object value : values){

            if (value != null){
                if (value instanceof String){
                    if (isNotBlank((String) value)) return true;
                }else{
                    return true;
                }
            }

        }
        return false;
    }
}
