package com.kiun.functionary.service

import java.io.InputStream
import java.util.*


enum class ImportState(val title: String) {

    Create("创建"),

    Started("正在导入"),

    Ask("等待操作"),

    Complete("完成"),

    Cancel("取消导入"),

    AskTimeOut("等待决策超时"),

    Fail("导入失败")
}

data class ImportError(

    /**
     * 行号
     */
    val row: Int,

    /**
     * 列名
     */
    val columnName: String,

    /**
     * 信息
     */
    val message: String,

    /**
     * 数据
     */
    var data: List<String>? = null
)

/**
 * 导入数据存档
 */
data class ImportData(

    /**
     * 存档ID
     */
    var id: String,

    /**
     * 状态
     */
    var state: ImportState = ImportState.Create,

    /**
     * 导入计划
     */
    var planId: String,

    /**
     * 导入集合名称
     */
    var planName: String,

    /**
     * 复制的公告ID
     */
    var noticeId: String,

    /**
     * 数据集合
     */
    var dataList: List<List<String>>,

    /**
     * 成功数量
     */
    var successCount: Int = 0,

    /**
     * 完成数量
     */
    var completeCount: Int = 0,

    /**
     * 错误列表
     */
    val errorList: MutableList<ImportError> = LinkedList<ImportError>(),

    /**
     * 开始时间
     */
    var startTime: Date = Date()
) {
    fun start(){
        state = ImportState.Started
        successCount = 0
        startTime = Date()
        errorList.clear()
    }

    fun toListItem() : ImportDataList {
        return ImportDataList(
            id = id,
            state = state.toString(),
            stateTitle = state.title,
            planName = planName,
            successCount = successCount,
            completeCount = completeCount,
            errorCount = errorList.size,
            dataCount = dataList.size - 1,
            startTime = startTime
            )
    }
}

data class ImportDataList(
    /**
     * 存档ID
     */
    var id: String,

    /**
     * 状态
     */
    var state: String,

    /**
     * 状态名称
     */
    var stateTitle: String,

    /**
     * 导入集合名称
     */
    var planName: String,

    /**
     * 成功数量
     */
    var successCount: Int = 0,

    /**
     * 完成数量
     */
    var completeCount: Int = 0,

    /**
     * 数据总数
     */
    var dataCount: Int = 0,

    /**
     * 错误数量
     */
    val errorCount: Int = 0,

    /**
     * 开始时间
     */
    var startTime: Date = Date()
)

interface ExcelService {

    /**
     * 创建导入
     * @param inputStream
     */
    fun importNotice(inputStream: InputStream, planId: String, noticeId: String): String

    /**
     * 导入显示预览
     */
    fun importReview(reviewId: String): List<List<String>>?

    /**
     * 开始导入
     */
    fun importStart(reviewId: String, copyNotice: Boolean)

    /**
     * 全部记录
     */
    fun allImportRecord(): List<ImportData>

    /**
     * 获取导入记录
     */
    fun recordById(reviewId: String) : ImportData?

    /**
     * 停止导入
     */
    fun stopImport(reviewId: String)

    /**
     * 删除导入
     */
    fun deleteImport(reviewId: String)

    /**
     * 响应决策
     */
    fun answer(reviewId: String, content: String)
}
