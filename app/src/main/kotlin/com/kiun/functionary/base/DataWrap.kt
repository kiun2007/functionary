package com.kiun.functionary.base

import com.github.pagehelper.Page

data class DataWrap<T>(
    val msg: String? = null,
    val data: T? = null,
    val code: Int = 0
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
            return DataWrap(msg = message, code = -1)
        }
    }
}

data class TableDataInfo<T>(

    /**
     * 总记录数
     * */
    var total: Long = 0,

    /**
     * 列表数据
     * */
    val rows: List<T>? = null,

    /**
     * 消息状态码
     * */
    val code: Int = 0,

    val msg: String? = null
){
    companion object {

        @JvmStatic
        fun<T> success(data: List<T>? = null): TableDataInfo<T> {
            var total = data?.size?:0
            if (data is Page<T>){
                total = data?.total.toInt()
            }
            return TableDataInfo(total = total?.toLong(), rows = data)
        }

        fun fail(msg: String?) : TableDataInfo<Any> {
            return TableDataInfo<Any>(msg = msg)
        }
    }
}
