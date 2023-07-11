package com.kiun.functionary.base

import com.kiun.functionary.dao.BaseExample
import org.apache.ibatis.annotations.Param

interface BaseExampleMapper<E : BaseExample, R> {

    /**
     * 查询总数
     */
    fun countByExample(example: E?): Long

    /**
     * 删除数据
     */
    fun deleteByExample(example: E?): Int

    /**
     * 插入数据
     */
    fun insertOne(record: R?): Int

    /**
     * 插入一条数据
     */
    fun insertSelective(record: R?): Int

    /**
     * 查询结果
     */
    fun selectByExample(example: E?): List<R>?

    /**
     * 根据条件更新
     * 空值不覆盖
     */
    fun updateByExampleSelective(@Param("record") record: R?, @Param("example") example: E?): Int

    /**
     * 根据条件更新
     * 全覆盖
     */
    fun updateByExample(@Param("record") record: R?, @Param("example") example: E?): Int

    /**
     * 根据主键更新
     * 空值不覆盖
     */
    fun updateByPrimaryKeySelective(record: R?): Int

    /**
     * 根据主键更新
     * 全覆盖
     */
    fun updateByPrimaryKey(record: R?): Int
}
