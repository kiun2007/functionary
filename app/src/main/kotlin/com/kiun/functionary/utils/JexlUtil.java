package com.kiun.functionary.utils;

import com.kiun.functionary.service.utils.StringUtil;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JexlUtil {

    private static JexlEngine engine = new JexlEngine();
    private static Map<String, Expression> allExpression = new HashMap<>();

    private static Map<String, String> jsStrMap = new HashMap<>();

    static {
        engine.setDebug(false);
        engine.setSilent(true);
        engine.setCache(100000);
    }

    public static void setSilent(boolean silent){
        engine.setSilent(silent);
    }

    /**
     * 重组字符串
     * 查找符合表达式的项并与不符合表达式的项合并
     * @param regex 正则表达式
     * @param source 源字符串
     * @param join 合并时添加的字符
     * @param with 是否需要双引号
     * @param convert 查找的字符转换方法
     * @return 重组后的字符串
     */
    public static String recombination(String regex, String source, String join, boolean with, Function<String, String> convert){

        Matcher matcher = Pattern.compile(regex).matcher(source);
        List<String> paragraphs = new LinkedList<>();

        int lastEnd = 0;
        while (matcher.find()){
            String formula = matcher.group(1);

            if (matcher.start() > lastEnd){
                String plugString = source.substring(lastEnd, matcher.start());
                paragraphs.add(with?("\""+plugString+"\""):plugString);
            }
            paragraphs.add(convert==null?formula:convert.apply(formula));
            lastEnd = matcher.end();
        }

        if (!paragraphs.isEmpty()){
            if (lastEnd < source.length() - 1){
                String plugString = source.substring(lastEnd);
                paragraphs.add(with?("\""+plugString+"\""):plugString);
            }
            return paragraphs.stream().collect(Collectors.joining(join));
        }else{
            return with?("\""+source+"\""):source;
        }
    }

    public static String translateJs(String js){
        String result = recombination("`([^`]*)`", js, "", false,
                source-> recombination("\\$\\{(.+?)\\}", source, "+", true, null)
        );
        return result;
    }

    public static String jsToExp(String funStr){

        String retStr = jsStrMap.get(funStr);

        if (jsStrMap.containsKey(funStr)){
            return retStr;
        }

        if (funStr.matches(".*?\\{\\{.+?\\}\\}.*?")){
            retStr = JexlUtil.recombination("\\{\\{(.+?)\\}\\}", funStr, "+", true, null);
        }
        else if (funStr.matches("`([^`]*)`")) {
            retStr = JexlUtil.recombination("`([^`]*)`", funStr, "", false,
                    source-> JexlUtil.recombination("\\$\\{(.+?)\\}", source, "+", true, null)
            );
        }
        else if (funStr.matches(".*?\\$\\{.+?\\}.*?")){
            retStr = JexlUtil.recombination("\\$\\{(.+?)\\}", funStr, "+", true, null);
        }
        jsStrMap.put(funStr, retStr);
        return retStr;
    }

    public static Object exec(String exp, Map<String, Object> map){

        if (exp == null) return null;

        Expression e;
        if (allExpression.containsKey(exp)){
            e = allExpression.get(exp);
        }else{
            e = engine.createExpression(exp);
            allExpression.put(exp, e);
        }

        MapContext context = new MapContext(map);
        return e.evaluate(context);
    }

    public static Object convertToCode(String jexlExp, Map<String, Object> map) {
        JexlEngine jexlEngine = new JexlEngine();
        Expression e = jexlEngine.createExpression(jexlExp);
        JexlContext jc = new MapContext();
        for (String key : map.keySet()) {
            jc.set(key, map.get(key));
        }
        Object retVal = e.evaluate(jc);
        if (null == retVal) {
            return "";
        }
        return retVal;
    }
}
