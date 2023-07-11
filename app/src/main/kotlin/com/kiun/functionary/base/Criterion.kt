package com.kiun.functionary.base

data class Criterion(
        var condition: String? = null,
        var value: Any? = null,
        var secondValue: Any? = null,
        var typeHandler: String? = null
) {
    val noValue = value == null

    val singleValue: Boolean = !(value is List<*>)

    val listValue: Boolean = value is List<*>

    val betweenValue = secondValue != null
}
