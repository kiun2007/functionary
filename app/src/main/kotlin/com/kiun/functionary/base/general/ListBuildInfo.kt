package com.kiun.functionary.base.general


/**
 * 列表表单构建
 */
annotation class ListBuild(

        /**
         * 数据库表名称
         */
        val value: String,

        /**
         * 列表标题
         */
        val title: String,

        /**
         * 编辑页面名称
         */
        val editUrl: String = "edit",

        /**
         * 新增页面名称
         */
        val addUrl: String = "add"
)

data class ListBuildData(

        /**
         * 数据库表名称
         */
        val value: String? = null,

        /**
         * 列表标题
         */
        val title: String? = null,

        /**
         * 编辑页面名称
         */
        val editUrl: String = "edit",

        /**
         * 新增页面名称
         */
        val addUrl: String = "add"
)

/**
 * 列表构建项
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ListBuildItem (

        /**
         * 字段名称, 默认用字段名称
         */
        val value: String = "",

        /**
         * 标题
         */
        val title: String,

        /**
         * 表单类型
         */
        val type: FormType = FormType.Auto,

        /**
         * 枚举
         */
        val enums: Array<String> = [],

        /**
         * 字段是否在表格显示
         */
        val tableWith: Boolean = true,

        /**
         * 添加页面是否存在字段
         */
        val addWith: Boolean = true,

        /**
         * 编辑页面是否存在字段
         */
        val editWith: Boolean = true
)

data class ListBuildItemData (

        /**
         * 字段名称
         */
        val value: String? = null,

        /**
         * 标题
         */
        val title: String? = null,

        /**
         * 表单类型
         */
        val type: String? = null,

        /**
         * 枚举
         */
        val enums: Map<String, String>? = null,

        /**
         * 字段是否在表格显示
         */
        val tableWith: Boolean = true,

        /**
         * 添加页面是否存在字段
         */
        val addWith: Boolean = true,

        /**
         * 编辑页面是否存在字段
         */
        val editWith: Boolean = true
)
