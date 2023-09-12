package com.kiun.functionary.service.utils

import com.google.gson.Gson
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.component.SpringUtils
import jakarta.servlet.http.HttpServletResponse
import org.apache.catalina.core.ApplicationContext
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import java.util.*

operator fun Any.set(s: String, value: Any?) {

    val methodName = "set${s.substring(0, 1).toUpperCase(Locale.ROOT)}${s.substring(1)}"
    try{
        val methods = this.javaClass.methods.filter {
            it.name.equals(methodName) && it.parameterTypes.size == 1
        }

        if (methods.isNotEmpty()){
            methods[0].invoke(this, value)
        }
    }catch (ex: Exception){
        ex.printStackTrace()
    }
}

operator fun Any.get(s: String): Any?{

    val methodName = "get${s.substring(0, 1).toUpperCase(Locale.ROOT)}${s.substring(1)}"
    try{
        val methods = this.javaClass.methods.filter {
            it.name.equals(methodName) && it.parameterTypes.isEmpty()
        }
        if (methods.isNotEmpty()){
            return methods[0].invoke(this)
        }
    }catch (ex: Exception){
        ex.printStackTrace()
    }
    return null
}

operator fun Number.compareTo(right: Number): Int {
    if(this.toDouble() > right.toDouble()){
        return 1
    }else if (this.toDouble() < right.toDouble()){
        return -1
    }
    return 0
}

/**
 * 统计
 */
inline fun <T, R: Number> Iterable<T>.total(predicate: (T) -> R): R {

    var count:Double = 0.0
//    if (this is Collection && isEmpty()) return count as R

    for (element in this){
        count += predicate(element).toDouble()
    }
    return count as R
}

/**
 * 约等于
 * @param eqValue 被判断值
 * @param floating 浮动范围
 */
inline fun <T: Number> T.approximately(eqValue: T, floating: T) : Boolean {

    if (eqValue.compareTo(this) != 0){
        return Math.abs(eqValue.toDouble() - this.toDouble()) <= floating.toDouble()
    }
    return true
}

inline fun Any.toJson(): String{
    val bean = SpringUtils.getBean(Gson::class.java)
    return bean.toJson(this)
}

inline fun Any.toMap(): Map<String, Any> {
    val bean = SpringUtils.getBean(Gson::class.java)
    return bean.fromJson(this.toJson(), object : ParameterizedTypeReference<Map<String, Any>>(){}.type)
}


inline fun HttpServletResponse.writeAny(any: Any){
    this.contentType = "application/json;charset=utf-8"
    this.writer.print(any.toJson())
    this.writer.flush()
    this.writer.close()
}

