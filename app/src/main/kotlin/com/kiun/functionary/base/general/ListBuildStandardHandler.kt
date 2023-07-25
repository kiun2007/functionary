package com.kiun.functionary.base.general


interface ListBuildStandardHandler<T> {

    /**
     * 获取
     */
    fun get(id: Long): T?

    /**
     * 列表
     */
    fun list(query: T): MutableList<T>?

    /**
     * 保存
     */
    fun save(entity: T): T?

    /**
     * 删除
     */
    fun delete(id: Long): Boolean
}
