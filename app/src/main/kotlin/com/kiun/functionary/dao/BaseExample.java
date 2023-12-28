package com.kiun.functionary.dao;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.kiun.functionary.base.BaseCriteria;
import com.kiun.functionary.base.anno.UseQuery;
import com.kiun.functionary.base.general.UserId;
import com.kiun.functionary.base.query.QueryFunction;
import com.kiun.functionary.component.ExampleFinder;
import com.kiun.functionary.context.AppContext;
import com.kiun.functionary.dao.sys.entity.SysUser;
import com.kiun.functionary.service.utils.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class BaseExample {

    protected String orderByClause;

    private boolean isList(Object object){
        if (object instanceof List){
            List first = (List) object;
            if (first.size() > 0){
                return true;
            }
            return false;
        }

        try {
            Field field = object.getClass().getSuperclass().getDeclaredField("criteria");
            field.setAccessible(true);

            if (List.class.isAssignableFrom(field.getType())){
                List list = (List) field.get(object);
                if (list.size() > 0){
                    return true;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }


        return false;
    }

    public boolean isEmpty(){

        try {
            Field field = this.getClass().getDeclaredField("oredCriteria");
            field.setAccessible(true);

            List list = (List) field.get(this);
            if (list != null && list.size() > 0 && isList(list.get(0))){
                return false;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
        return true;
    }

    public static BaseExample getExample(String table) throws Exception{
        ExampleFinder finder = AppContext.getApplicationContext().getBean(ExampleFinder.class);
        return finder.findAndCreate(table);
    }

    public Class getEntryClass() throws ClassNotFoundException {
        return Class.forName(this.getClass().getName().replaceAll("Example", ""));
    }

    private static BaseCriteria createCriteria(BaseExample example) throws Exception {

        Method createCriteria;
        try {
            createCriteria = example.getClass().getMethod("createCriteria");
        } catch (NoSuchMethodException e) {
            throw new Exception("系统性错误,缺少createCriteria");
        }
        return (BaseCriteria) createCriteria.invoke(example);
    }

    private static void andBetween(String field, GeneralListQuery.Query query, Object create) throws Exception{

        Class criteriaClz = create.getClass();

        if (Integer.class.getSimpleName().equals(query.getValue())){
            Method method = criteriaClz.getMethod(String.format("and%sBetween", field, query), Integer.class, Integer.class);
            method.invoke(create, (int)query.getMin(), (int)query.getMax());
        }else if (Date.class.getSimpleName().equals(query.getValue())){
            Method method = criteriaClz.getMethod(String.format("and%sBetween", field, query), Date.class, Date.class);
            method.invoke(create, new Date(query.getMin()), new Date(query.getMax()));
        }
    }

    private static void andQuery(String field, Object value, String query, Object create) throws Exception {

        Class<?> criteriaClz = create.getClass();
        Class<?> paramClz = value.getClass();
        if (value instanceof List){
            paramClz = List.class;
        }
        criteriaClz.getMethod(String.format("and%s%s", field, query), paramClz).invoke(create, value);
    }

    /**
     * 填充Example
     * @param entity
     */
    public <E extends BaseExample> E fillEntity(Object entity, String type) throws Exception {

        BaseCriteria criteria = createCriteria(this);

        for (Field field : entity.getClass().getDeclaredFields()){

            UseQuery useQuery = field.getAnnotation(UseQuery.class);
            boolean isDelete = false;
            field.setAccessible(true);
            Object value = field.get(entity);

            if(useQuery != null){
                QueryFunction queryFunction = useQuery.value().getConstructor(String.class).newInstance(useQuery.setting());
                queryFunction.fieldName(field.getName());
                queryFunction.fieldValue(value);

                queryFunction.convert(criteria);
                isDelete = queryFunction.isDelete();
            }

            UserId userId = field.getAnnotation(UserId.class);
            if (value == null && userId != null){
                SysUser user = AppContext.currentUser();
                value = user == null ? null : user.getId();
            }

            if (!isDelete){
                criteria.addCriterion(StringUtil.camelToUnderline(field.getName()).toLowerCase(Locale.ROOT) + " = ", value, field.getName());
            }
        }
        return (E) this;
    }

    public <E extends BaseExample> E fill(Map<String, Object> map, String queryType) throws Exception {

        GeneralListQuery query = new GeneralListQuery();
        query.setSearch(
            map.entrySet().stream().map(item->
                GeneralListQuery.Query.of(
                        item.getKey(),
                        item.getValue().toString(),
                        GeneralListQuery.QueryType.valueOf(queryType))
            ).collect(Collectors.toList())
        );
        fillQuery(query);
        return (E) this;
    }

    public BaseExample fillQuery(GeneralListQuery query) throws Exception {

        Object create = createCriteria(this);
        List<GeneralListQuery.Query> queryList = query.getSearch();

        if(queryList != null){
            for (GeneralListQuery.Query item : queryList){

                String field = item.getField();
                field = field.substring(0, 1).toUpperCase() + field.substring(1);

                switch (item.getType()) {
                    case Eq -> andQuery(field, item.getValue(), "EqualTo", create);
                    case Ne -> andQuery(field, item.getValue(), "NotEqualTo", create);
                    case Like -> andQuery(field, String.format("%%%s%%", item.getValue()), "Like", create);
                    case Lt -> andQuery(field, item.getValue(), "LessThan", create);
                    case Between -> andBetween(field, item, create);
                    case In -> andQuery(field, Arrays.asList(item.getValue().split(",")), "In", create);
                    case Asc -> this.orderByClause = String.format("%s ASC", field);
                    case Desc -> this.orderByClause = String.format("%s DESC", field);
                }
            }
        }
        return this;
    }

    public static BaseExample createOfQuery(GeneralListQuery query) throws Exception{
        BaseExample example = getExample(query.getTable());
        example.fillQuery(query);
        return example;
    }
}
