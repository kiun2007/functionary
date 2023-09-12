package com.kiun.functionary.base.general

import com.kiun.functionary.service.utils.toJson


annotation class Operate(

    /**
     * 标题
     */
    val title: String,

    /**
     * 方法名称
     */
    val function: String = "openModel",

    /**
     * 图标
     */
    val icon: String = "fa-edit",

    /**
     * URL
     */
    val url: String = "edit",

    /**
     * 按钮颜色
     */
    val color: String = ButtonColor.BrandColor,

    /**
     * 是否在工具栏
     */
    val toolbar: Boolean = false
)

/**
 * 弹出选择框
 */
annotation class Select(

    /**
     * 显示字段
     */
    val label: String = "",

    /**
     * 显示字段来源
     */
    val formLabel: String = "",

    /**
     * 值字段来源
     */
    val formValue: String = "",

    /**
     * 页面地址
     */
    val url: String = ""
)

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
     * 操作页面及名称
     */
    val operate: Array<Operate> = [
        Operate("删除", function = "removeAll", color = ButtonColor.Danger, icon = "fa-remove", toolbar = true),
        Operate("添加", url = "/general/add/@{formId}", color = ButtonColor.BrandColor, icon = "fa-plus", toolbar = true),
        Operate("编辑", url = "/general/edit/@{formId}?id={id}"),
        Operate("删除", url = "/general/delete", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
    ]
)

data class OperateData(

    /**
     * 标题
     */
    val title: String,

    /**
     * 是否为方法
     */
    val function: String = "openModel",

    /**
     * 图标
     */
    val icon: String = "fa-edit",

    /**
     * URL
     */
    val url: String = "edit",

    /**
     * 按钮颜色
     */
    val color: String = "#1c84c6",

    /**
     * 是否在工具栏
     */
    val toolbar: Boolean = false
){
    fun jsonString() : String{
        return this.toJson()
    }
}


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
     * 操作页
     */
    val operate: Array<OperateData>? = null
){
    fun toolbars() : Array<OperateData>?{
        return operate?.filter { it.toolbar }?.toTypedArray()
    }
}

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class UserId()

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
     * 选中弹框页面URL
     */
    val selectOpt: Select = Select(),

        /**
     * 标识
     */
    val flag: Int = FormFlag.Add or FormFlag.Edit or FormFlag.Search or FormFlag.Table
)

data class SelectData(
    /**
     * 显示字段
     */
    val label: String = "",

    /**
     * 显示字段来源
     */
    val formLabel: String = "",

    /**
     * 值字段来源
     */
    val formValue: String = "",

    /**
     * 页面地址
     */
    val url: String = ""
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
     * 选中弹框页面配置
     */
    val selectOpt: SelectData? = null,

    /**
     * 标识
     */
    val flag: Int
){
    fun getAddWith(): Boolean{
        return (flag and FormFlag.Add) != 0
    }

    fun getEditWith(): Boolean{
        return (flag and FormFlag.Edit) != 0
    }

    fun getSearchWith(): Boolean{
        return (flag and FormFlag.Search) != 0
    }

    fun getAddDisable(): Boolean{
        return (flag and FormFlag.AddDisable) != 0
    }

    fun getEditDisable(): Boolean{
        return (flag and FormFlag.EditDisable) != 0
    }

    fun getSearchDisable(): Boolean{
        return (flag and FormFlag.SearchDisable) != 0
    }

    fun getSearchTitleWith(): Boolean{
        return getSearchWith() && type != FormType.Hidden.toString()
    }

    fun getTableWith(): Boolean{
        return (flag and FormFlag.Table) != 0
    }

    fun jsonString() : String{
        return this.toJson()
    }
}
