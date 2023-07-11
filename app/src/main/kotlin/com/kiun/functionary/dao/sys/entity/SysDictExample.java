package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.Criterion;
import java.util.ArrayList;
import java.util.List;

public class SysDictExample extends com.kiun.functionary.dao.BaseExample {
    /**
     * 2023-07-10 20:55:36
     */
    protected boolean distinct;

    /**
     * 2023-07-10 20:55:36
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public SysDictExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_dict
     * 2023-07-10 20:55:36
     */
    protected abstract static class GeneratedCriteria extends com.kiun.functionary.base.BaseCriteria {

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public Criteria andDictIdIsNull() {
            addCriterion("dict_id is null");
            return (Criteria) this;
        }

        public Criteria andDictIdIsNotNull() {
            addCriterion("dict_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictIdEqualTo(String value) {
            addCriterion("dict_id =", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotEqualTo(String value) {
            addCriterion("dict_id <>", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThan(String value) {
            addCriterion("dict_id >", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThanOrEqualTo(String value) {
            addCriterion("dict_id >=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThan(String value) {
            addCriterion("dict_id <", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThanOrEqualTo(String value) {
            addCriterion("dict_id <=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLike(String value) {
            addCriterion("dict_id like", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotLike(String value) {
            addCriterion("dict_id not like", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdIn(List<String> values) {
            addCriterion("dict_id in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotIn(List<String> values) {
            addCriterion("dict_id not in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdBetween(String value1, String value2) {
            addCriterion("dict_id between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotBetween(String value1, String value2) {
            addCriterion("dict_id not between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNull() {
            addCriterion("dict_name is null");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNotNull() {
            addCriterion("dict_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictNameEqualTo(String value) {
            addCriterion("dict_name =", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotEqualTo(String value) {
            addCriterion("dict_name <>", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThan(String value) {
            addCriterion("dict_name >", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThanOrEqualTo(String value) {
            addCriterion("dict_name >=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThan(String value) {
            addCriterion("dict_name <", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThanOrEqualTo(String value) {
            addCriterion("dict_name <=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLike(String value) {
            addCriterion("dict_name like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotLike(String value) {
            addCriterion("dict_name not like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameIn(List<String> values) {
            addCriterion("dict_name in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotIn(List<String> values) {
            addCriterion("dict_name not in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameBetween(String value1, String value2) {
            addCriterion("dict_name between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotBetween(String value1, String value2) {
            addCriterion("dict_name not between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andGroupDictIsNull() {
            addCriterion("group_dict is null");
            return (Criteria) this;
        }

        public Criteria andGroupDictIsNotNull() {
            addCriterion("group_dict is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDictEqualTo(String value) {
            addCriterion("group_dict =", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictNotEqualTo(String value) {
            addCriterion("group_dict <>", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictGreaterThan(String value) {
            addCriterion("group_dict >", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictGreaterThanOrEqualTo(String value) {
            addCriterion("group_dict >=", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictLessThan(String value) {
            addCriterion("group_dict <", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictLessThanOrEqualTo(String value) {
            addCriterion("group_dict <=", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictLike(String value) {
            addCriterion("group_dict like", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictNotLike(String value) {
            addCriterion("group_dict not like", value, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictIn(List<String> values) {
            addCriterion("group_dict in", values, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictNotIn(List<String> values) {
            addCriterion("group_dict not in", values, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictBetween(String value1, String value2) {
            addCriterion("group_dict between", value1, value2, "groupDict");
            return (Criteria) this;
        }

        public Criteria andGroupDictNotBetween(String value1, String value2) {
            addCriterion("group_dict not between", value1, value2, "groupDict");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_dict
     * do_not_delete_during_merge 2023-07-10 20:55:36
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}