package com.kiun.functionary.service.imps

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.context.AnalysisContext
import com.alibaba.excel.read.listener.ReadListener
import com.kiun.functionary.dao.gks.ImportPlanColumnMapper
import com.kiun.functionary.dao.gks.ImportPlanMapper
import com.kiun.functionary.dao.gks.JobNoticeMapper
import com.kiun.functionary.dao.gks.entity.ExcelJobInfo
import com.kiun.functionary.service.ExcelService
import com.kiun.functionary.service.OrganService
import com.kiun.functionary.service.PySpiderService
import com.kiun.functionary.utils.format
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.InputStream
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableMap
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.forEach
import kotlin.collections.groupBy
import kotlin.collections.joinToString
import kotlin.collections.map
import kotlin.collections.set
import kotlin.collections.sortBy

data class ImportData(

    var id: String,

    var planId: String,

    var noticeId: String,

    var dataList: List<List<String>>
)

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
        reviewMap[id] = ImportData(id = id, planId = planId, noticeId = noticeId, dataList = headAndList)
        return id
    }

    override fun importReview(reviewId: String): List<List<String>>? {
        return reviewMap[reviewId]?.dataList
    }

    override fun importStart(reviewId: String, copyNotice: Boolean): Boolean {

        val dataList = reviewMap[reviewId]?.dataList ?: return false
        val noticeId = reviewMap[reviewId]!!.noticeId
        var notice = noticeService?.selectByPrimaryKey(noticeId)
        val noticeTitle = notice?.title ?: ""

        val headList = dataList[0]
        for (i in 1 until dataList.size){

            val jobInfo = ExcelJobInfo(
                noticeId = noticeId,
                headList = headList,
                dataList = dataList[i]
            )

            if (copyNotice){
                notice?.flushId()
                val allInfo = jobInfo.allInfo()

                val region = allInfo["区域"]
                val orgNm = allInfo["工作单位"]

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
        }
        return true
    }
}
