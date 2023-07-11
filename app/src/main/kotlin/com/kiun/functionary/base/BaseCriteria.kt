package com.kiun.functionary.base

open class BaseCriteria {

    @JvmField
    protected var criteria: MutableList<Criterion>? = null

    fun addCriterion(condition: String) {
        criteria?.add(Criterion(condition))
    }

    fun addCriterion(condition: String, value: Any?, property: String) {
        if (value != null) {
            criteria?.add(Criterion(condition, value))
        }
    }

    fun addCriterion(condition: String, value1: Any?, value2: Any?, property: String) {
        if (value1 == null || value2 == null) {
            return
        }
        criteria?.add(Criterion(condition, value1, value2))
    }
}
