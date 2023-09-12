package com.kiun.functionary.base.general

object FormFlag
{
    const val Non = 0x0
    /**
     * 添加页面存在
     */
    const val Add = 0x01

    /**
     * 编辑页面存在
     */
    const val Edit = 0x02

    /**
     * 搜索存在
     */
    const val Search = 0x04

    /**
     * 列表中存在
     */
    const val Table = 0x08

    /**
     * 添加时禁止编辑
     */
    const val AddDisable = 0x10

    /**
     * 修改时禁止编辑
     */
    const val EditDisable = 0x10

    /**
     * 搜索是禁用
     */
    const val SearchDisable = 0x40

    /**
     * 全支持
     */
    const val All = Add or Edit or Search or Table

    /**
     * 修改组合
     */
    const val Update = Add or Edit

    /**
     * 表格组合
     */
    const val TableSearch = Search or Table
}

object ButtonColor {

    const val BrandColor = "#409EFF"

    const val Success = "#67C23A"

    const val Warning = "#E6A23C"

    const val Danger = "#F56C6C"

    const val Info = "#909399"
}

/**
 * 表单类型
 */
enum class FormType{

    /**
     * 文本类型
     */
    Text,

    /**
     * 数字
     */
    Number,

    /**
     * 布尔类型
     */
    Bool,

    /**
     * 弹出选择输入
     */
    Select,

    /**
     * 枚举
     */
    Enum,

    /**
     * 日期
     */
    Date,

    /**
     * 时间
     */
    Time,

    /**
     * 日期和时间
     */
    DateAndTime,

    /**
     * 单行代码
     */
    CodeLine,

    /**
     * 多行代码
     */
    CodeMultiline,

    /**
     * 隐藏
     */
    Hidden,

    /**
     * 自动
     */
    Auto
}
