package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.Criterion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobMustAgeExample extends com.kiun.functionary.dao.BaseExample {
    /**
     * 2023-10-14 08:56:45
     */
    protected boolean distinct;

    /**
     * 2023-10-14 08:56:45
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public JobMustAgeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
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
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gks_job_must_age
     * 2023-10-14 08:56:45
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

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(String value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(String value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(String value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(String value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(String value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(String value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLike(String value) {
            addCriterion("job_id like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotLike(String value) {
            addCriterion("job_id not like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<String> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<String> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(String value1, String value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(String value1, String value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andYoungAgeIsNull() {
            addCriterion("young_age is null");
            return (Criteria) this;
        }

        public Criteria andYoungAgeIsNotNull() {
            addCriterion("young_age is not null");
            return (Criteria) this;
        }

        public Criteria andYoungAgeEqualTo(Date value) {
            addCriterion("young_age =", value, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeNotEqualTo(Date value) {
            addCriterion("young_age <>", value, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeGreaterThan(Date value) {
            addCriterion("young_age >", value, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeGreaterThanOrEqualTo(Date value) {
            addCriterion("young_age >=", value, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeLessThan(Date value) {
            addCriterion("young_age <", value, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeLessThanOrEqualTo(Date value) {
            addCriterion("young_age <=", value, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeIn(List<Date> values) {
            addCriterion("young_age in", values, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeNotIn(List<Date> values) {
            addCriterion("young_age not in", values, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeBetween(Date value1, Date value2) {
            addCriterion("young_age between", value1, value2, "youngAge");
            return (Criteria) this;
        }

        public Criteria andYoungAgeNotBetween(Date value1, Date value2) {
            addCriterion("young_age not between", value1, value2, "youngAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeIsNull() {
            addCriterion("old_age is null");
            return (Criteria) this;
        }

        public Criteria andOldAgeIsNotNull() {
            addCriterion("old_age is not null");
            return (Criteria) this;
        }

        public Criteria andOldAgeEqualTo(Date value) {
            addCriterion("old_age =", value, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeNotEqualTo(Date value) {
            addCriterion("old_age <>", value, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeGreaterThan(Date value) {
            addCriterion("old_age >", value, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeGreaterThanOrEqualTo(Date value) {
            addCriterion("old_age >=", value, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeLessThan(Date value) {
            addCriterion("old_age <", value, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeLessThanOrEqualTo(Date value) {
            addCriterion("old_age <=", value, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeIn(List<Date> values) {
            addCriterion("old_age in", values, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeNotIn(List<Date> values) {
            addCriterion("old_age not in", values, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeBetween(Date value1, Date value2) {
            addCriterion("old_age between", value1, value2, "oldAge");
            return (Criteria) this;
        }

        public Criteria andOldAgeNotBetween(Date value1, Date value2) {
            addCriterion("old_age not between", value1, value2, "oldAge");
            return (Criteria) this;
        }

        public Criteria andEducationIdIsNull() {
            addCriterion("education_id is null");
            return (Criteria) this;
        }

        public Criteria andEducationIdIsNotNull() {
            addCriterion("education_id is not null");
            return (Criteria) this;
        }

        public Criteria andEducationIdEqualTo(String value) {
            addCriterion("education_id =", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotEqualTo(String value) {
            addCriterion("education_id <>", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdGreaterThan(String value) {
            addCriterion("education_id >", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdGreaterThanOrEqualTo(String value) {
            addCriterion("education_id >=", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdLessThan(String value) {
            addCriterion("education_id <", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdLessThanOrEqualTo(String value) {
            addCriterion("education_id <=", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdLike(String value) {
            addCriterion("education_id like", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotLike(String value) {
            addCriterion("education_id not like", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdIn(List<String> values) {
            addCriterion("education_id in", values, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotIn(List<String> values) {
            addCriterion("education_id not in", values, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdBetween(String value1, String value2) {
            addCriterion("education_id between", value1, value2, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotBetween(String value1, String value2) {
            addCriterion("education_id not between", value1, value2, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationNameIsNull() {
            addCriterion("education_name is null");
            return (Criteria) this;
        }

        public Criteria andEducationNameIsNotNull() {
            addCriterion("education_name is not null");
            return (Criteria) this;
        }

        public Criteria andEducationNameEqualTo(String value) {
            addCriterion("education_name =", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotEqualTo(String value) {
            addCriterion("education_name <>", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameGreaterThan(String value) {
            addCriterion("education_name >", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameGreaterThanOrEqualTo(String value) {
            addCriterion("education_name >=", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameLessThan(String value) {
            addCriterion("education_name <", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameLessThanOrEqualTo(String value) {
            addCriterion("education_name <=", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameLike(String value) {
            addCriterion("education_name like", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotLike(String value) {
            addCriterion("education_name not like", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameIn(List<String> values) {
            addCriterion("education_name in", values, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotIn(List<String> values) {
            addCriterion("education_name not in", values, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameBetween(String value1, String value2) {
            addCriterion("education_name between", value1, value2, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotBetween(String value1, String value2) {
            addCriterion("education_name not between", value1, value2, "educationName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gks_job_must_age
     * do_not_delete_during_merge 2023-10-14 08:56:45
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}