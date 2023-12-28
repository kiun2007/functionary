package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.Criterion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImportPlanColumnExample extends com.kiun.functionary.dao.BaseExample {
    /**
     * 2023-11-13 09:15:20
     */
    protected boolean distinct;

    /**
     * 2023-11-13 09:15:20
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public ImportPlanColumnExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
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
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gks_plan_column
     * 2023-11-13 09:15:20
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(String value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(String value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(String value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(String value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(String value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLike(String value) {
            addCriterion("plan_id like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotLike(String value) {
            addCriterion("plan_id not like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<String> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<String> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(String value1, String value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(String value1, String value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andColumnIndexIsNull() {
            addCriterion("column_index is null");
            return (Criteria) this;
        }

        public Criteria andColumnIndexIsNotNull() {
            addCriterion("column_index is not null");
            return (Criteria) this;
        }

        public Criteria andColumnIndexEqualTo(Integer value) {
            addCriterion("column_index =", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexNotEqualTo(Integer value) {
            addCriterion("column_index <>", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexGreaterThan(Integer value) {
            addCriterion("column_index >", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_index >=", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexLessThan(Integer value) {
            addCriterion("column_index <", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexLessThanOrEqualTo(Integer value) {
            addCriterion("column_index <=", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexIn(List<Integer> values) {
            addCriterion("column_index in", values, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexNotIn(List<Integer> values) {
            addCriterion("column_index not in", values, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexBetween(Integer value1, Integer value2) {
            addCriterion("column_index between", value1, value2, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("column_index not between", value1, value2, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnFieldIsNull() {
            addCriterion("column_field is null");
            return (Criteria) this;
        }

        public Criteria andColumnFieldIsNotNull() {
            addCriterion("column_field is not null");
            return (Criteria) this;
        }

        public Criteria andColumnFieldEqualTo(String value) {
            addCriterion("column_field =", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldNotEqualTo(String value) {
            addCriterion("column_field <>", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldGreaterThan(String value) {
            addCriterion("column_field >", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldGreaterThanOrEqualTo(String value) {
            addCriterion("column_field >=", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldLessThan(String value) {
            addCriterion("column_field <", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldLessThanOrEqualTo(String value) {
            addCriterion("column_field <=", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldLike(String value) {
            addCriterion("column_field like", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldNotLike(String value) {
            addCriterion("column_field not like", value, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldIn(List<String> values) {
            addCriterion("column_field in", values, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldNotIn(List<String> values) {
            addCriterion("column_field not in", values, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldBetween(String value1, String value2) {
            addCriterion("column_field between", value1, value2, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnFieldNotBetween(String value1, String value2) {
            addCriterion("column_field not between", value1, value2, "columnField");
            return (Criteria) this;
        }

        public Criteria andColumnTitleIsNull() {
            addCriterion("column_title is null");
            return (Criteria) this;
        }

        public Criteria andColumnTitleIsNotNull() {
            addCriterion("column_title is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTitleEqualTo(String value) {
            addCriterion("column_title =", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotEqualTo(String value) {
            addCriterion("column_title <>", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleGreaterThan(String value) {
            addCriterion("column_title >", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleGreaterThanOrEqualTo(String value) {
            addCriterion("column_title >=", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleLessThan(String value) {
            addCriterion("column_title <", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleLessThanOrEqualTo(String value) {
            addCriterion("column_title <=", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleLike(String value) {
            addCriterion("column_title like", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotLike(String value) {
            addCriterion("column_title not like", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleIn(List<String> values) {
            addCriterion("column_title in", values, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotIn(List<String> values) {
            addCriterion("column_title not in", values, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleBetween(String value1, String value2) {
            addCriterion("column_title between", value1, value2, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotBetween(String value1, String value2) {
            addCriterion("column_title not between", value1, value2, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnFormatIsNull() {
            addCriterion("column_format is null");
            return (Criteria) this;
        }

        public Criteria andColumnFormatIsNotNull() {
            addCriterion("column_format is not null");
            return (Criteria) this;
        }

        public Criteria andColumnFormatEqualTo(String value) {
            addCriterion("column_format =", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatNotEqualTo(String value) {
            addCriterion("column_format <>", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatGreaterThan(String value) {
            addCriterion("column_format >", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatGreaterThanOrEqualTo(String value) {
            addCriterion("column_format >=", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatLessThan(String value) {
            addCriterion("column_format <", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatLessThanOrEqualTo(String value) {
            addCriterion("column_format <=", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatLike(String value) {
            addCriterion("column_format like", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatNotLike(String value) {
            addCriterion("column_format not like", value, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatIn(List<String> values) {
            addCriterion("column_format in", values, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatNotIn(List<String> values) {
            addCriterion("column_format not in", values, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatBetween(String value1, String value2) {
            addCriterion("column_format between", value1, value2, "columnFormat");
            return (Criteria) this;
        }

        public Criteria andColumnFormatNotBetween(String value1, String value2) {
            addCriterion("column_format not between", value1, value2, "columnFormat");
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

        public Criteria andAddUserNmIsNull() {
            addCriterion("add_user_nm is null");
            return (Criteria) this;
        }

        public Criteria andAddUserNmIsNotNull() {
            addCriterion("add_user_nm is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserNmEqualTo(String value) {
            addCriterion("add_user_nm =", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmNotEqualTo(String value) {
            addCriterion("add_user_nm <>", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmGreaterThan(String value) {
            addCriterion("add_user_nm >", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmGreaterThanOrEqualTo(String value) {
            addCriterion("add_user_nm >=", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmLessThan(String value) {
            addCriterion("add_user_nm <", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmLessThanOrEqualTo(String value) {
            addCriterion("add_user_nm <=", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmLike(String value) {
            addCriterion("add_user_nm like", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmNotLike(String value) {
            addCriterion("add_user_nm not like", value, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmIn(List<String> values) {
            addCriterion("add_user_nm in", values, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmNotIn(List<String> values) {
            addCriterion("add_user_nm not in", values, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmBetween(String value1, String value2) {
            addCriterion("add_user_nm between", value1, value2, "addUserNm");
            return (Criteria) this;
        }

        public Criteria andAddUserNmNotBetween(String value1, String value2) {
            addCriterion("add_user_nm not between", value1, value2, "addUserNm");
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

        public Criteria andUpdUserNmIsNull() {
            addCriterion("upd_user_nm is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmIsNotNull() {
            addCriterion("upd_user_nm is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmEqualTo(String value) {
            addCriterion("upd_user_nm =", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmNotEqualTo(String value) {
            addCriterion("upd_user_nm <>", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmGreaterThan(String value) {
            addCriterion("upd_user_nm >", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmGreaterThanOrEqualTo(String value) {
            addCriterion("upd_user_nm >=", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmLessThan(String value) {
            addCriterion("upd_user_nm <", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmLessThanOrEqualTo(String value) {
            addCriterion("upd_user_nm <=", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmLike(String value) {
            addCriterion("upd_user_nm like", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmNotLike(String value) {
            addCriterion("upd_user_nm not like", value, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmIn(List<String> values) {
            addCriterion("upd_user_nm in", values, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmNotIn(List<String> values) {
            addCriterion("upd_user_nm not in", values, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmBetween(String value1, String value2) {
            addCriterion("upd_user_nm between", value1, value2, "updUserNm");
            return (Criteria) this;
        }

        public Criteria andUpdUserNmNotBetween(String value1, String value2) {
            addCriterion("upd_user_nm not between", value1, value2, "updUserNm");
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
     * This class corresponds to the database table gks_plan_column
     * do_not_delete_during_merge 2023-11-13 09:15:20
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}