package com.kiun.functionary.service

import com.kiun.functionary.dao.BaseExample


interface GeneralService {

    fun <T> selectList(tableName: String, request: Map<String, Any>): List<T>?

    fun insertOrUpdateSelective(tableName: String, body: String): Boolean

    fun insert(tableName: String, body: String): Boolean
}
