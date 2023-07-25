package com.kiun.mybatis.auto.generate;

public class EntryAndAttribute {

    private String name;

    private String value;

    private String attribute;

    private int sort;

    public EntryAndAttribute(String name, String value, String attribute, int sort) {
        this.name = name;
        this.value = value;
        this.attribute = attribute;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
