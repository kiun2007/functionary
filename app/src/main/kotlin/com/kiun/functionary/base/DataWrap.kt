package com.kiun.functionary.base

import org.springframework.boot.json.GsonJsonParser
import org.springframework.http.converter.json.GsonBuilderUtils
import org.springframework.http.converter.json.GsonFactoryBean

data class DataWrap<T>(
    val message: String? = null,
    val data: T? = null,
    val success: Boolean = true
){

    companion object{

        /**
         * 创建成功的数据反馈并包裹数据
         */
        @JvmStatic
        fun<T> success(data: T? = null): DataWrap<T> {
            return DataWrap(data = data)
        }

        /**
         * 创建失败的数据反馈并包裹原因
         */
        @JvmStatic
        fun<T> fail(message: String?): DataWrap<T> {
            return DataWrap(message = message, success = false)
        }
    }
}
