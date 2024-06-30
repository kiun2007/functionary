package com.kiun.functionary.dao.lz.entity

data class BettingCreate(

    /**
     * 下注类型
     */
    var type: String?,

    /**
     * 下注数量
     */
    var count: Int?,

    /**
     *  选中值
     */
    var selectedItems: Array<String>?
)
