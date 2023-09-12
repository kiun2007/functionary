package com.kiun.functionary.utils;

import com.kiun.functionary.utils.data.FieldGetter;
import com.kiun.functionary.utils.data.FieldMapping;
import com.kiun.functionary.utils.data.FieldRead;
import com.kiun.functionary.utils.data.KeyValue;
import com.kiun.functionary.utils.data.getter.ObjectGetter;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

import static com.kiun.functionary.utils.ClassUtil.*;

public class ObjectUtil {

    private static Map<String,Map<AccessibleObject, KeyValue<String,Class<? extends FieldGetter>>>> allAccessMap;

    static {
        allAccessMap = new HashMap<>();
    }

    public static class InvokeHandler{

        private Method method = null;

        private InvokeHandler(Class<?> clz, String name, Class<?> ... classes){
            try {
                method = clz.getDeclaredMethod(name, classes);
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        public void invoke(Object object, Object... params){

            if (method != null) {
                try {
                    method.invoke(object, params);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 寻找公私有方法.
     * @param clz
     * @param name
     * @param classes
     * @return
     */
    public static InvokeHandler findMethod(Class<?> clz, String name, Class<?> ... classes){
        return new InvokeHandler(clz, name, classes);
    }

    public static Class getGenericClass(ParameterizedType parameterizedType, int i) {
        Object genericClass = parameterizedType.getActualTypeArguments()[i];
        if (genericClass instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) genericClass).getRawType();
        } else if (genericClass instanceof GenericArrayType) {
            return (Class) ((GenericArrayType) genericClass).getGenericComponentType();
        } else if (genericClass instanceof TypeVariable) {
            return getClass(((TypeVariable) genericClass).getBounds()[0], 0);
        } else {
            return (Class) genericClass;
        }
    }

    public static Class getClass(Type type, int i) {
        if (type instanceof ParameterizedType) {
            return getGenericClass((ParameterizedType) type, i);
        } else if (type instanceof TypeVariable) {
            return getClass(((TypeVariable) type).getBounds()[0], 0);
        } else {
            return (Class) type;
        }
    }

    public static <T> Class getTClass(T t) {

        Type[] params = t.getClass().getGenericInterfaces();
        Type type = params[0];
        Type finalNeedType;
        if (params.length > 1) {
            if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");
            finalNeedType = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            finalNeedType = type;
        }
        final Class clazz = getClass(finalNeedType, 0);
        return clazz;
    }

    public static FieldRead getMappingName(AccessibleObject access, Class src, String flag){
        FieldMapping mapping = access.getAnnotation(FieldMapping.class);
        if (mapping != null){
            for (FieldRead fieldRead : mapping.value()){
                if (fieldRead.type().equals(src) && fieldRead.flag().equals(flag)){
                    return fieldRead;
                }
            }
        }else{
            FieldRead fieldRead = access.getAnnotation(FieldRead.class);
            if (fieldRead != null){
                return fieldRead;
            }
        }
        return null;
    }

    private static void addMappingByAccess(Map<AccessibleObject, KeyValue<String,Class<? extends FieldGetter>>> accessMap,
                                           AccessibleObject[] accessibles, Class srcClz, String flag, boolean isMethod){

        for (AccessibleObject access : accessibles){
            Member member = (Member) access;
            if (Modifier.isStatic(member.getModifiers())){
                continue;
            }

            FieldRead mappingReader = getMappingName(access, srcClz, flag);
            //跳过不是set方法和特别标注的方法,没有标注的私有字段..
            if (isMethod){
                Method method = (Method) access;
                if ((member.getName().indexOf("set") < 0 && mappingReader == null) || method.getGenericParameterTypes().length != 1){
                    continue;
                }
            }else{
                if (!Modifier.isPublic(member.getModifiers()) && mappingReader == null){
                    continue;
                }
            }
            accessMap.put(access, new KeyValue<>(mappingReader != null ? mappingReader.field() : member.getName(),mappingReader != null? mappingReader.getter():null));
        }
    }

    private static Object getValue(KeyValue<String,Class<? extends FieldGetter>> fieldGetter, Object src, Type type) throws Exception {

        Class srcClz = src.getClass();

        FieldGetter fieldGet;
        if (fieldGetter.value() == null){
            fieldGet = new ObjectGetter(src);
        }else{
            Type actualTypes[] = ((ParameterizedType)fieldGetter.value().getGenericSuperclass()).getActualTypeArguments();
            Constructor<FieldGetter> constructor = (Constructor<FieldGetter>) fieldGetter.value().getConstructor((Class<?>) actualTypes[0]);
            fieldGet = constructor.newInstance(src);
        }

        return fieldGet.getValue(fieldGetter.key(), type);
    }

    private static Map<AccessibleObject, KeyValue<String,Class<? extends FieldGetter>>> getAccessMap(Class destClz, Class srcClz, String flag){

        Map<AccessibleObject, KeyValue<String,Class<? extends FieldGetter>>> accessMap;
        String destClzName = destClz.getName();

        accessMap = new HashMap<>();
        //提取公共的方法和字段.
        while(!destClz.getSimpleName().equals(Object.class.getSimpleName())){
            addMappingByAccess(accessMap, destClz.getMethods(), srcClz, flag, true);
            addMappingByAccess(accessMap, destClz.getDeclaredFields(), srcClz, flag, false);
            destClz = destClz.getSuperclass();
        }
        return accessMap;
    }

    /**
     * 将一个对象按照映射规则复制到另一个对象.
     * @param dest 数据目标值,这个对象应该包含映射规则的注解.
     * @param src 数据源,为目标提供数据的复制.
     */
    public static<T> T copyByMapping(Object dest, T src){
        copyByMapping(dest, src, "");
        return src;
    }

    /**
     * 将一个对象按照映射规则复制到另一个对象.
     * @param dest 数据目标值,这个对象应该包含映射规则的注解.
     * @param src 数据源,为目标提供数据的复制.
     * @param flag 如果有多个映射规则,提供该规则的标志,可以直接使用此规则.
     */
    public static void copyByMapping(Object dest, Object src, String flag){

        Class destClz = dest.getClass();
        Class srcClz = src.getClass();

        Map<AccessibleObject, KeyValue<String,Class<? extends FieldGetter>>> accessMap = getAccessMap(destClz, srcClz, flag);
        for (AccessibleObject access : accessMap.keySet()) {
            try {
                if (access instanceof Method) {
                    Method method = (Method) access;
                    Object value = getValue(accessMap.get(access), src, method.getGenericParameterTypes()[0]);
                    if (value != null) method.invoke(dest, value);
                } else if (access instanceof Field) {
                    Field field = (Field) access;
                    Object value = getValue(accessMap.get(access), src, field.getType());
                    if (value != null) field.set(dest, value);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private static boolean equalsClass(Class src, Class dest){
        if (src.equals(dest)){
            return true;
        }

        if (isOriginalType(src) && isBaseType(dest)){

            if (isLogicType(src) && isLogicType(dest)){
                return true;
            }

            if (isCharType(src) && isCharType(dest)){
                return true;
            }

            int srcLevel = getBaseTypeLevel(src);
            int destLevel = getBaseTypeLevel(dest);
            if (srcLevel > -1 && destLevel > -1){
                return srcLevel >= destLevel;
            }
            return false;
        }

        if (src.isAssignableFrom(dest)){
            return true;
        }

        return false;
    }

    private static boolean isChildClass(Class[] src, Class[] dest){

        if (src.length != dest.length){
            return false;
        }

        for (int i = 0; i < src.length; i++) {
            if (!equalsClass(src[i], dest[i])){
                return false;
            }
        }
        return true;
    }

    private static Class<?>[] getObjectClass(Object... values){

        Class<?>[] classes = new Class[values.length];

        for (int i = 0; i < values.length; i++) {
            classes[i] = values[i].getClass();
        }
        return classes;
    }

    //选择最合适的执行方法.
    private static Constructor<?> getItemPlan(Constructor<?>[] list, String name, Class<?>[] classes){

        Constructor<?> constructor = null;
        for (Constructor<?> item : list){
            if (name == null || item.getName().equals(name)){
                if (isChildClass(item.getParameterTypes(), classes)){
                    constructor = item;
                    break;
                }
            }
        }
        return constructor;
    }

    public static boolean isEmpty(Object object){

        for (Field field : object.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                if (!Modifier.isStatic(field.getModifiers()) && field.get(object) != null){
                    return false;
                }
            } catch (IllegalAccessException e) {
            }
        }
        return true;
    }

    public static<T> T newObject(Class<T> clz, Object... values){

        if (values.length == 0){

            try {
                return (T) clz.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
            return null;
        }

        try {
            Class<?>[] classes = getObjectClass(values);
            Constructor<?>[] constructors = clz.getConstructors();
            Constructor<?> constructor = getItemPlan(constructors, null, classes);

            if (constructor != null){
                return (T) constructor.newInstance(values);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static<T> T getValue(Object object, String fieldName, Class<T> clz){

        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(object);
            if (value != null && clz.isAssignableFrom(value.getClass())){
                return (T) value;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
        return null;
    }

    /**
     * 尝试多个赋值，任意值可填充均返回成功
     * @param object
     * @param fieldName
     * @param values
     * @return
     */
    public static boolean setValue(Object object, String fieldName, Object[] values){

        for (Object value : values) {
            if (setValue(object, fieldName, value, false)){
                return true;
            }
        }
        return false;
    }

    public static boolean setValue(Object object, String fieldName, Object value, boolean noCover){
        try {
            //不覆盖原有值
            if (noCover && getValue(object, fieldName, Object.class) != null){
                return false;
            }

            Field field = object.getClass().getDeclaredField(fieldName);
            if(value == null || !field.getType().equals(value.getClass()) || !field.getType().isAssignableFrom(value.getClass())){
                return false;
            }
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean setValue(Object object, String fieldName, Object value){
        return setValue(object, fieldName, value, false);
    }

    public static <T> T get(Object object, String methodName, Class<T> clz){

        try {
            Method method = object.getClass().getMethod(methodName);
            Object value = method.invoke(object);
            if (value != null && clz.isAssignableFrom(value.getClass())){
                return (T) value;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object create(String clzName, Object... params){

        try {
            Class clz = Class.forName(clzName);
            return newObject(clz, params);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <A extends Annotation> A getFirstAnnotation(Class clz, Class<A> annoClz){

        for (Class itemClz = clz; itemClz != null; itemClz = itemClz.getSuperclass()){
            A anno = (A) itemClz.getAnnotation(annoClz);
            if (anno != null){
                return anno;
            }
        }
        return null;
    }
}
