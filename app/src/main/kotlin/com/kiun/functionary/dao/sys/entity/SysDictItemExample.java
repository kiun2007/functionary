package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.Criterion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDictItemExample extends com.kiun.functionary.dao.BaseExample {
    /**
     * 2023-07-25 23:15:07
     */
    protected boolean distinct;

    /**
     * 2023-07-25 23:15:07
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public SysDictItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
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
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_dict_item
     * 2023-07-25 23:15:07
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

        public Criteria andItemKeyIsNull() {
            addCriterion("item_key is null");
            return (Criteria) this;
        }

        public Criteria andItemKeyIsNotNull() {
            addCriterion("item_key is not null");
            return (Criteria) this;
        }

        public Criteria andItemKeyEqualTo(String value) {
            addCriterion("item_key =", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotEqualTo(String value) {
            addCriterion("item_key <>", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyGreaterThan(String value) {
            addCriterion("item_key >", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyGreaterThanOrEqualTo(String value) {
            addCriterion("item_key >=", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyLessThan(String value) {
            addCriterion("item_key <", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyLessThanOrEqualTo(String value) {
            addCriterion("item_key <=", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyLike(String value) {
            addCriterion("item_key like", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotLike(String value) {
            addCriterion("item_key not like", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyIn(List<String> values) {
            addCriterion("item_key in", values, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotIn(List<String> values) {
            addCriterion("item_key not in", values, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyBetween(String value1, String value2) {
            addCriterion("item_key between", value1, value2, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotBetween(String value1, String value2) {
            addCriterion("item_key not between", value1, value2, "itemKey");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andItemValIsNull() {
            addCriterion("item_val is null");
            return (Criteria) this;
        }

        public Criteria andItemValIsNotNull() {
            addCriterion("item_val is not null");
            return (Criteria) this;
        }

        public Criteria andItemValEqualTo(String value) {
            addCriterion("item_val =", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValNotEqualTo(String value) {
            addCriterion("item_val <>", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValGreaterThan(String value) {
            addCriterion("item_val >", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValGreaterThanOrEqualTo(String value) {
            addCriterion("item_val >=", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValLessThan(String value) {
            addCriterion("item_val <", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValLessThanOrEqualTo(String value) {
            addCriterion("item_val <=", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValLike(String value) {
            addCriterion("item_val like", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValNotLike(String value) {
            addCriterion("item_val not like", value, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValIn(List<String> values) {
            addCriterion("item_val in", values, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValNotIn(List<String> values) {
            addCriterion("item_val not in", values, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValBetween(String value1, String value2) {
            addCriterion("item_val between", value1, value2, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemValNotBetween(String value1, String value2) {
            addCriterion("item_val not between", value1, value2, "itemVal");
            return (Criteria) this;
        }

        public Criteria andItemOrderIsNull() {
            addCriterion("item_order is null");
            return (Criteria) this;
        }

        public Criteria andItemOrderIsNotNull() {
            addCriterion("item_order is not null");
            return (Criteria) this;
        }

        public Criteria andItemOrderEqualTo(Integer value) {
            addCriterion("item_order =", value, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderNotEqualTo(Integer value) {
            addCriterion("item_order <>", value, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderGreaterThan(Integer value) {
            addCriterion("item_order >", value, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_order >=", value, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderLessThan(Integer value) {
            addCriterion("item_order <", value, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderLessThanOrEqualTo(Integer value) {
            addCriterion("item_order <=", value, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderIn(List<Integer> values) {
            addCriterion("item_order in", values, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderNotIn(List<Integer> values) {
            addCriterion("item_order not in", values, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderBetween(Integer value1, Integer value2) {
            addCriterion("item_order between", value1, value2, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andItemOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("item_order not between", value1, value2, "itemOrder");
            return (Criteria) this;
        }

        public Criteria andAddUserIdIsNull() {
            addCriterion("add_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAddUserIdIsNotNull() {
            addCriterion("add_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserIdEqualTo(String value) {
            addCriterion("add_user_id =", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotEqualTo(String value) {
            addCriterion("add_user_id <>", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdGreaterThan(String value) {
            addCriterion("add_user_id >", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("add_user_id >=", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdLessThan(String value) {
            addCriterion("add_user_id <", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdLessThanOrEqualTo(String value) {
            addCriterion("add_user_id <=", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdLike(String value) {
            addCriterion("add_user_id like", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotLike(String value) {
            addCriterion("add_user_id not like", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdIn(List<String> values) {
            addCriterion("add_user_id in", values, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotIn(List<String> values) {
            addCriterion("add_user_id not in", values, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdBetween(String value1, String value2) {
            addCriterion("add_user_id between", value1, value2, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotBetween(String value1, String value2) {
            addCriterion("add_user_id not between", value1, value2, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserMnIsNull() {
            addCriterion("add_user_mn is null");
            return (Criteria) this;
        }

        public Criteria andAddUserMnIsNotNull() {
            addCriterion("add_user_mn is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserMnEqualTo(String value) {
            addCriterion("add_user_mn =", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnNotEqualTo(String value) {
            addCriterion("add_user_mn <>", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnGreaterThan(String value) {
            addCriterion("add_user_mn >", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnGreaterThanOrEqualTo(String value) {
            addCriterion("add_user_mn >=", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnLessThan(String value) {
            addCriterion("add_user_mn <", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnLessThanOrEqualTo(String value) {
            addCriterion("add_user_mn <=", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnLike(String value) {
            addCriterion("add_user_mn like", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnNotLike(String value) {
            addCriterion("add_user_mn not like", value, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnIn(List<String> values) {
            addCriterion("add_user_mn in", values, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnNotIn(List<String> values) {
            addCriterion("add_user_mn not in", values, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnBetween(String value1, String value2) {
            addCriterion("add_user_mn between", value1, value2, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddUserMnNotBetween(String value1, String value2) {
            addCriterion("add_user_mn not between", value1, value2, "addUserMn");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNull() {
            addCriterion("upd_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNotNull() {
            addCriterion("upd_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdEqualTo(String value) {
            addCriterion("upd_user_id =", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotEqualTo(String value) {
            addCriterion("upd_user_id <>", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThan(String value) {
            addCriterion("upd_user_id >", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("upd_user_id >=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThan(String value) {
            addCriterion("upd_user_id <", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThanOrEqualTo(String value) {
            addCriterion("upd_user_id <=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLike(String value) {
            addCriterion("upd_user_id like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotLike(String value) {
            addCriterion("upd_user_id not like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIn(List<String> values) {
            addCriterion("upd_user_id in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotIn(List<String> values) {
            addCriterion("upd_user_id not in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdBetween(String value1, String value2) {
            addCriterion("upd_user_id between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotBetween(String value1, String value2) {
            addCriterion("upd_user_id not between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnIsNull() {
            addCriterion("upd_user_mn is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnIsNotNull() {
            addCriterion("upd_user_mn is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnEqualTo(String value) {
            addCriterion("upd_user_mn =", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnNotEqualTo(String value) {
            addCriterion("upd_user_mn <>", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnGreaterThan(String value) {
            addCriterion("upd_user_mn >", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnGreaterThanOrEqualTo(String value) {
            addCriterion("upd_user_mn >=", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnLessThan(String value) {
            addCriterion("upd_user_mn <", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnLessThanOrEqualTo(String value) {
            addCriterion("upd_user_mn <=", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnLike(String value) {
            addCriterion("upd_user_mn like", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnNotLike(String value) {
            addCriterion("upd_user_mn not like", value, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnIn(List<String> values) {
            addCriterion("upd_user_mn in", values, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnNotIn(List<String> values) {
            addCriterion("upd_user_mn not in", values, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnBetween(String value1, String value2) {
            addCriterion("upd_user_mn between", value1, value2, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdUserMnNotBetween(String value1, String value2) {
            addCriterion("upd_user_mn not between", value1, value2, "updUserMn");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpIsNull() {
            addCriterion("upd_terminal_ip is null");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpIsNotNull() {
            addCriterion("upd_terminal_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpEqualTo(String value) {
            addCriterion("upd_terminal_ip =", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpNotEqualTo(String value) {
            addCriterion("upd_terminal_ip <>", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpGreaterThan(String value) {
            addCriterion("upd_terminal_ip >", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpGreaterThanOrEqualTo(String value) {
            addCriterion("upd_terminal_ip >=", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpLessThan(String value) {
            addCriterion("upd_terminal_ip <", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpLessThanOrEqualTo(String value) {
            addCriterion("upd_terminal_ip <=", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpLike(String value) {
            addCriterion("upd_terminal_ip like", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpNotLike(String value) {
            addCriterion("upd_terminal_ip not like", value, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpIn(List<String> values) {
            addCriterion("upd_terminal_ip in", values, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpNotIn(List<String> values) {
            addCriterion("upd_terminal_ip not in", values, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpBetween(String value1, String value2) {
            addCriterion("upd_terminal_ip between", value1, value2, "updTerminalIp");
            return (Criteria) this;
        }

        public Criteria andUpdTerminalIpNotBetween(String value1, String value2) {
            addCriterion("upd_terminal_ip not between", value1, value2, "updTerminalIp");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_dict_item
     * do_not_delete_during_merge 2023-07-25 23:15:07
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}