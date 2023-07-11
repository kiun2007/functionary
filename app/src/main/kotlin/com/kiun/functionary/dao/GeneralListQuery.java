package com.kiun.functionary.dao;

import java.util.List;

public class GeneralListQuery {

    public GeneralListQuery(){
    }

    private List<Query> search;

    private int pageNum = 1;

    private int pageSize = 10;

    private int limit = -1;

    private String field;

    private String table;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Query> getSearch() {
        return search;
    }

    public void setSearch(List<Query> search) {
        this.search = search;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public static class Query{

        private String field;

        private QueryType type;

        private String value;

        private long min;

        private long max;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public QueryType getType() {
            return type;
        }

        public void setType(QueryType type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public long getMin() {
            return min;
        }

        public void setMin(long min) {
            this.min = min;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public static Query of(String filed, String value, QueryType queryType){
            Query query = new Query();
            query.setField(filed);
            query.setValue(value);
            query.setType(queryType);
            return query;
        }
    }

    public enum QueryType {
        Like, Eq, In, Ne, Lt, Gt, Lte, Gte, Asc, Desc, Between, Clear
    }
}
