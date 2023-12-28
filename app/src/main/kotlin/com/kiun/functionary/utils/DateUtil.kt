package com.kiun.functionary.utils

import java.text.SimpleDateFormat
import java.util.*

enum class SpanType {

    /**
     * 年
     */
    Year,

    /**
     * 月
     */
    Month,

    /**
     * 日
     */
    Day,

    /**
     * 时
     */
    Hour,

    /**
     * 分
     */
    Minute,

    /**
     * 秒
     */
    Second
}

data class DateSpan(

    val value: Int,

    val type: SpanType
)

operator fun Date.minus(span: DateSpan): Date {
    return this.plus(DateSpan(span.value * -1, span.type))
}

operator fun Date.plus(span: DateSpan): Date {

    val calendar = Calendar.getInstance()
    calendar.time = this

    when(span.type){
        SpanType.Year -> calendar.add(Calendar.YEAR, span.value)
        SpanType.Month -> calendar.add(Calendar.MONTH, span.value)
        SpanType.Day -> calendar.add(Calendar.DAY_OF_YEAR, span.value)
        SpanType.Hour -> TODO()
        SpanType.Minute -> TODO()
        SpanType.Second -> TODO()
    }
    return calendar.time
}

inline fun String.toDate(format: String): Date{

    if (format.isEmpty()){
        return Date()
    }
    val format = SimpleDateFormat(format)
    return format.parse(this)
}

inline fun MatchGroupCollection.toDate(si: Int = 1, sd: Date = Date()) : Date {

    val year = this[1]?.value?.toInt()?:sd.year
    val month = this[2]?.value?.toInt()?:sd.month
    val dayOfYear = this[3]?.value?.toInt()?:sd.date

    return "%04d-%02d-%02d".format(year, month, dayOfYear).toDate("yyyy-MM-dd")
}
