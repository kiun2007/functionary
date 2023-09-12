package com.kiun.functionary.service

import com.kiun.functionary.dao.gks.entity.UserAttribute

interface UserAttributeService {

    /**
     * 保存属性，若存在替换值
     */
    fun save(attriList: List<UserAttribute>): List<UserAttribute>

    /**
     * 相同字典的直接删除重新添加
     */
    fun replace(attriList: List<UserAttribute>): List<UserAttribute>

    /**
     * 获取字相关属性
     */
    fun getByDict(dictId: String? = null): List<UserAttribute>?
}
