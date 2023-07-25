package com.kiun.functionary.service

import com.kiun.functionary.base.general.ListBuildData
import com.kiun.functionary.base.general.ListBuildItemData
import com.kiun.functionary.dao.BaseExample


interface GeneralService {

    fun <T> selectList(tableName: String, request: Map<String, Any>): List<T>?

    fun insertOrUpdateSelective(tableName: String, body: String): Boolean

    fun insert(tableName: String, body: String): Boolean

    fun getBuildByName(name: String) : ListBuildData?

    fun listBuildItem(name: String): List<ListBuildItemData>?

    fun <T> getById(tableName: String, id: String) : T
}
