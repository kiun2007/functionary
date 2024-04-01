package com.kiun.functionary.service.imps

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.context.AnalysisContext
import com.alibaba.excel.read.listener.ReadListener
import com.kiun.functionary.base.MessageSession
import com.kiun.functionary.dao.gks.ImportPlanColumnMapper
import com.kiun.functionary.dao.gks.ImportPlanMapper
import com.kiun.functionary.dao.gks.JobNoticeMapper
import com.kiun.functionary.dao.gks.entity.ExcelJobInfo
import com.kiun.functionary.service.*
import com.kiun.functionary.utils.format
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.InputStream
import java.lang.RuntimeException
import java.util.*
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.set


@Service
class EasyExcelService : ExcelService {

    @Autowired
    val importPlanMapper: ImportPlanMapper? = null

    @Autowired
    val importPlanColumnMapper: ImportPlanColumnMapper? = null

    @Autowired
    val pySpiderService: PySpiderService? = null

    @Autowired
    var organService: OrganService? = null

    @Autowired
    var noticeService : JobNoticeMapper? = null

    @Autowired
    var messageSession : MessageSession? = null

    /**
     * 导入数据缓存
     */
    val reviewMap: MutableMap<String, ImportData> = HashMap()

    override fun importNotice(inputStream: InputStream, planId: String, noticeId: String): String {

        val plan = importPlanMapper?.selectByPrimaryKey(planId)
        val planColumns = importPlanColumnMapper?.selectByPlanId(planId)
        planColumns?.sortBy { it.columnIndex }
        val groupColumns = planColumns?.groupBy { it.columnTitle }

        var index = 0
        var headRowData: Map<Int, String?>? = null
        val list = LinkedList<List<String>>()

        EasyExcel.read(inputStream, object : ReadListener<MutableMap<Int, String?>> {
            override fun invoke(o: MutableMap<Int, String?>, context: AnalysisContext) {
                val nullCount = o.values.count { it == null }
                val valid = (nullCount.toFloat() / o.size) < 0.4

                if (index == (plan?.headIndex?:0)){
                    //头部数据处理
                    headRowData = o
                }

                if (index > (plan?.headIndex?:0) && valid){

                    val iList = LinkedList<String>()
                    groupColumns?.forEach { (t, u) ->
                        val values = u.joinToString(separator = "") { uit -> uit.format(o, headRowData)?:"" }
                        iList.add(values)
                    }

                    if (plan?.sheetField?.isNotEmpty() == true){
                        iList.add(context.readSheetHolder().sheetName)
                    }
                    list.add(iList)
                }

                if (valid){
                    index++
                }
            }

            override fun doAfterAllAnalysed(context: AnalysisContext) {
                index = 0
            }
        }).doReadAll()

        val headAndList = LinkedList<List<String>>()
        groupColumns?.map { (t, u)-> t }?.let {

            val newIt = LinkedList<String>()
            newIt.addAll(it)
            if (plan?.sheetField?.isNotEmpty() == true){
                newIt.add(plan.sheetField)
            }
            headAndList.add(newIt)
        }
        headAndList.addAll(list)

        val id = UUID.randomUUID().toString()
        reviewMap[id] = ImportData(id = id, planId = planId, planName = plan?.title ?: "--", noticeId = noticeId, dataList = headAndList)
        return id
    }

    override fun importReview(reviewId: String): List<List<String>>? {
        return reviewMap[reviewId]?.dataList
    }

    @Async
    @Transactional
    override fun importStart(reviewId: String, copyNotice: Boolean) {

        val reviewData = reviewMap[reviewId] ?: return
        //标记为已开始
        reviewData.start()

        val dataList = reviewData.dataList
        val noticeId = reviewData.noticeId
        var notice = noticeService?.selectByPrimaryKey(noticeId)
        val noticeTitle = notice?.title ?: ""

        val headList = dataList[0]
        for (i in 1 until dataList.size){

            if (reviewData.state == ImportState.Cancel){
                throw RuntimeException("用户中止导入")
            }

            val jobInfo = ExcelJobInfo(
                noticeId = noticeId,
                headList = headList,
                dataList = dataList[i]
            )

            try {
                if (copyNotice){
                    notice?.flushId()
                    val allInfo = jobInfo.allInfo()

                    val region = allInfo["区域"]
                    val orgNm = allInfo["工作单位"]

                    //查找单位
                    val sysOrgan = organService?.createOrSearch(orgNm!!, notice!!.type, region)
                    var isNew = true

                    //工作单位相同无需新增
                    sysOrgan?.id.let {
                        noticeService?.selectByOrganId(it)?.firstOrNull()?.let {
                            notice = it
                            isNew = false
                        }
                    }

                    if(isNew){
                        notice?.inputType = "0"
                        notice?.organId = sysOrgan?.organId
                        notice?.rangCd = sysOrgan?.rangCd
                        notice?.rangId = sysOrgan?.rangId
                        notice?.rangName = sysOrgan?.rangName
                        notice?.title = "${noticeTitle}(${sysOrgan?.organName})"

                        noticeService?.insertSelective(notice)
                    }
                    jobInfo.noticeId = notice?.id
                }
                pySpiderService?.createJobDetails(jobInfo)
                reviewData.successCount ++
            } catch (e: Throwable){
                e.printStackTrace()
                synchronized(reviewData.errorList) {
                    reviewData.errorList.add(ImportError(row = i, "区域", e?.message ?: "", reviewData.dataList[i]))
                }
            }
            reviewData.completeCount ++
        }

        //全部都失败的情况
        if(reviewData.successCount == 0){
            reviewData.state = ImportState.Fail
            throw RuntimeException("无正确数据导入")
        }

        if(reviewData.errorList.isNotEmpty()){

            val decision: String?
            try {
                reviewData.state = ImportState.Ask
                decision = messageSession?.await<String>(3600L, "ExcelImport", reviewId)
            } catch (e: InterruptedException){
                reviewData.state = ImportState.Fail
                throw RuntimeException("发生未知错误")
            }

            if(decision == null){
                reviewData.state = ImportState.AskTimeOut
                throw RuntimeException("长时间未操作自动取消")
            }

            //确定提交
            if (decision == "C"){
                //提交
                reviewData.state = ImportState.Complete
                return
            } else {
                reviewData.state = ImportState.Cancel
                throw RuntimeException("用户取消")
            }
        }

        //未出问题 自动完成
        reviewData.state = ImportState.Complete
    }

    override fun allImportRecord(): List<ImportData> {
        return reviewMap.values.toList()
    }

    override fun recordById(reviewId: String): ImportData? {
        return reviewMap[reviewId]
    }

    override fun stopImport(reviewId: String) {
        if (reviewMap[reviewId]?.state != ImportState.Started){
            throw Exception("任务状态错误,无法中止,刷新后重试")
        }
        reviewMap[reviewId]?.state = ImportState.Cancel
    }

    override fun deleteImport(reviewId: String) {
        if (reviewMap[reviewId]?.state == ImportState.Started){
            throw Exception("任务已开始, 请中止任务后删除")
        }
        if (reviewMap[reviewId]?.state == ImportState.Ask){
            throw Exception("任务等待决策，无法删除，请尽快完成决策")
        }
        reviewMap.remove(reviewId)
    }

    override fun answer(reviewId: String, content: String) {
        messageSession?.push("ExcelImport", reviewId, content)
    }
}
