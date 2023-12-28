package com.kiun.functionary.service.imps

import com.kiun.functionary.dao.gks.JobDetailsMapper
import com.kiun.functionary.dao.gks.JobMustAgeMapper
import com.kiun.functionary.dao.gks.JobMustMapper
import com.kiun.functionary.dao.gks.JobNoticeMapper
import com.kiun.functionary.dao.gks.entity.*
import com.kiun.functionary.dao.sys.SysDictItemMapper
import com.kiun.functionary.dao.sys.SysOrganMapper
import com.kiun.functionary.dao.sys.entity.SysDictItem
import com.kiun.functionary.dao.sys.entity.SysDictItemExample
import com.kiun.functionary.dao.sys.entity.SysOrgan
import com.kiun.functionary.pyspider.ageEntryByGkld
import com.kiun.functionary.pyspider.specialityByGkld
import com.kiun.functionary.service.OrganService
import com.kiun.functionary.service.PySpiderService
import com.kiun.functionary.utils.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.SQLIntegrityConstraintViolationException
import java.util.Date
import java.util.LinkedList

/**
 * 8.社区工作者：公告标题或公告正文包含有社区工作者 关键字的归为 社区工作者类
 * 9.招警：公告标题或公告正文包含有警察 关键字的归为 招警类
 * 10.法检：公告标题或公告正文包含有法院或检察院 ？关键字的归为 法检类
 */
@Service
class PySpiderServiceImp : PySpiderService {

    @Autowired
    var noticeService : JobNoticeMapper? = null

    @Autowired
    var organMapper : SysOrganMapper? = null

    @Autowired
    var jobDetailMapper: JobDetailsMapper? = null

    @Autowired
    var sysDictItemMapper: SysDictItemMapper? = null

    @Autowired
    var jobMustMapper: JobMustMapper? = null

    @Autowired
    var jobMustAgeMapper: JobMustAgeMapper? = null

    @Autowired
    var organService: OrganService? = null

    fun withKeyText(text: String?, keys: Array<String>) : Boolean
    {
        if (text == null){
            return false
        }

        for (key in keys){
            if (text.contains(key)){
                return true
            }
        }
        return false
    }

    private fun getNoticeType(type: String, title: String?, details: String? = null): String?
    {
        //查询相关
        val sysDictItemExample = SysDictItemExample()
        val sysDictItemCriteria = sysDictItemExample.createCriteria()
        sysDictItemCriteria.andDictIdEqualTo("gks_type").andItemAliasEqualTo(type.replace("[", "").replace("]",""))
        val dictItem = sysDictItemMapper?.selectByExample(sysDictItemExample)?.firstOrNull()

        // 确定类型
        if (dictItem != null){
            //已存在类型
            return dictItem.itemKey
        } else {
            //8.社区工作者：公告标题或公告正文包含有社区工作者 关键字的归为 社区工作者类
            if (withKeyText(title, arrayOf("社区工作者", "网格")) || withKeyText(details, arrayOf("社区工作者", "网格"))){
                return "gklx9"
            }
            //9.招警：公告标题或公告正文包含有警察 关键字的归为 招警类
            else if (withKeyText(title, arrayOf("警察", "辅警")) || withKeyText(details, arrayOf("警察", "辅警"))){
                return "gklx10"
            }
            //10.法检：公告标题或公告正文包含有法院或检察院 ？关键字的归为 法检类
            else if (withKeyText(title, arrayOf("法院", "检察院")) || withKeyText(details, arrayOf("法院", "检察院"))){
                return "gklx11"
            }
            else
            {
                return null
            }
        }
    }

    override fun createNotice(notice: PySpiderNotice): String? {

        var isUpdate = false
        noticeService?.selectByJobUrl(notice.jobUrl)?.firstOrNull()?.let {
            notice.id = it.id
            isUpdate = true
        }

        //查询相关
        notice.type = getNoticeType(notice.type, notice.title, notice.details)

        val sysOrgan = organService?.createOrSearch(notice.organName!!, notice.type, notice.region)

        notice.rangCd = sysOrgan?.rangCd
        notice.rangId = sysOrgan?.rangId
        notice.rangName = sysOrgan?.rangName
        notice.organId = sysOrgan?.id

        if (!isUpdate){
            notice.addTime = Date()
            notice.addUserId = "pyspider"
            notice.addUserNm = "爬虫用户"
        }
        notice.updTime = Date()
        notice.updUserId = "pyspider"
         notice.updUserNm = "爬虫用户"
        notice.updTerminalIp = "127.0.0.1"

        if (isUpdate){
            noticeService?.updateByPrimaryKeySelective(notice)
        }else{
            noticeService?.insertOne(notice)
        }
        return notice.id
    }

    override fun createJobDetails(jobInfo: JobInfoData): String {

        val jobDetails = jobDetailMapper?.selectBySourceUrl(jobInfo.sourceUrl)?.firstOrNull() ?: JobDetails()
        jobDetails.jobNotice = jobInfo.noticeId

        //全部学历
        val educationList = sysDictItemMapper?.selectByDictId("gks_education")?.sortedBy { it.itemKey }
        //全部工作经验时长
        val undergoList = sysDictItemMapper?.selectByDictId("gks_education")

        val notice = noticeService?.selectByPrimaryKey(jobInfo.noticeId)
        jobDetails.region = notice?.rangCd
        jobDetails.type = notice?.type

        val infoMap = jobInfo.allInfo()

        val specialitys = infoMap["专业要求"].toString().specialityByGkld()
        val ages = infoMap["年龄要求"].toString().ageEntryByGkld()

        //岗位人数
        jobDetails.jobCount = jobInfo.recruitNum?.toIntOrNull()?:-1
        //备注
        jobDetails.factorDesc = infoMap["备注"]
        //职位名称
        jobDetails.jobName = infoMap["职位名称"]
        //联系电话
        jobDetails.jobTele = infoMap["联系电话"]

        //户籍地
        val domicile = infoMap["户籍地"]
        if (domicile == null || domicile == "市内外"){
            jobDetails.factorDomicile = null
        }
        else
        {
            jobDetails.factorDomicile = notice?.rangCd
        }
        //年限
        val undergoItem = undergoList?.filter { it.itemVal == infoMap["基层工作经验"] }?.firstOrNull()
        jobDetails.factorUndergo = undergoItem?.itemKey
        //性别
        if (infoMap["性别要求"]?.contains("不限") == true){
            jobDetails.factorGender = null
        } else if (infoMap["性别要求"]?.contains("女") == true) {
            jobDetails.factorGender = "W"
        } else if (infoMap["性别要求"]?.contains("男") == true) {
            jobDetails.factorGender = "M"
        }

        //学历学位要求
        val educationMust = ".*(硕士|博士|本科|专科).*".toRegex().find(infoMap["学历要求"]?:"")?.groups?.get(1)?.value
        val academicMust = infoMap["学位要求"]

        val eduMustItem = if (academicMust == null || !".*(硕士|博士).*".toRegex().matches(academicMust)){
            educationList?.firstOrNull { educationMust?.contains(it.itemAlias) == true }
        }else{
            educationList?.firstOrNull { academicMust.contains(it.itemAlias) }
        }
        jobDetails.factorEducation = eduMustItem?.itemKey
        //原URL
        jobDetails.sourceUrl = jobInfo.sourceUrl
        //职位介绍
        jobDetails.jobWork = infoMap["职位介绍"]

        val mustAgeList = LinkedList<JobMustAge>()
        ages?.forEach { ageEntry ->
            if (ageEntry.educationName != null){
                val mustAges =
                    educationList?.filter { it.itemVal.contains(ageEntry.educationName?:"") }
                        ?.map {
                            val jobMustAge = JobMustAge()
                            jobMustAge.jobId = jobDetails.id
                            jobMustAge.youngAge = ageEntry.youngBirthday
                            jobMustAge.oldAge = ageEntry.oldBirthday
                            jobMustAge.educationId = it.id
                            jobMustAge.educationName = it.itemVal
                            return@map jobMustAge
                        }
                mustAgeList.addAll(mustAges!!)
            }
            else
            {
                val jobMustAge = JobMustAge()
                jobMustAge.jobId = jobDetails.id
                jobMustAge.youngAge = ageEntry.youngBirthday
                jobMustAge.oldAge = ageEntry.oldBirthday
                jobMustAge.educationId = ""
                mustAgeList.add(jobMustAge)
            }
        }

        mustAgeList.forEach {
            try {
                jobMustAgeMapper?.insertSelective(record = it)
            } catch (ex: Exception) {
            }
        }

        specialitys?.forEach { speciality->
            speciality.special?.forEach{ sit->

                val example = SysDictItemExample()
                example.createCriteria().andDictIdEqualTo("gks_speciality").andItemValEqualTo(sit.name)
                val specialList = sysDictItemMapper?.selectByExample(example)

                var specialItem: SysDictItem? = null
                var educationItems = educationList?.filter { it.itemAlias == educationMust }
                if (educationItems?.isNotEmpty() == false){
                    educationItems = educationList?.filter { it.itemKey == jobDetails.factorEducation }
                }

                if(specialList?.size == 1) {
                    specialItem = specialList!!.first()
                } else if ((specialList?.size?:0) > 1) {
                    specialItem = specialList?.firstOrNull {
                        educationItems?.any { eit ->
                            it.itemKey?.substring(0, 2) == String.format(
                                "%02d",
                                eit?.itemKey?.toInt()
                            )
                        } ?: false
                    }
                }

                if (specialItem == null){
                    return@forEach
                }

                if (specialItem.itemAlias == null && sit.code != null){
                    specialItem.itemAlias = sit.code
                    sysDictItemMapper?.updateByPrimaryKeySelective(specialItem)
                }

                //插入关联
                val jobMust = JobMust()
                jobMust.dictId = "gks_speciality"
                jobMust.jobId = jobDetails.id
                jobMust.noticeId = jobInfo.noticeId
                jobMust.dictItemId = specialItem.id
                jobMust.dictItemKey = specialItem.itemKey
                jobMust.dictItemValue = specialItem.itemVal

                try {
                    jobMustMapper?.insertSelective(jobMust)
                }catch (_: Throwable){
                }
            }
        }

        if (jobDetails.isNew){
            jobDetails.addTime = Date()
            jobDetails.updUserId = jobInfo.importUser()
            jobDetails.updUserNm = jobInfo.importUserNm()
        }
        jobDetails.updTime = Date()
        jobDetails.updUserId = jobInfo.importUser()
        jobDetails.updUserNm = jobInfo.importUserNm()
        jobDetails.updTerminalIp = "127.0.0.1"
        if (jobDetails.isNew){
            jobDetailMapper?.insertSelective(jobDetails)
        } else {
            jobDetailMapper?.updateByPrimaryKeySelective(jobDetails)
        }
        return jobDetails.id
    }

    override fun verifyNotice(jobInfo: NoticeListItem): Int {
        val type = jobInfo.type?.let { getNoticeType(it, jobInfo.title) } ?: return 1

        if (jobInfo.time?.contains("小时") == true || jobInfo.time?.contains("分钟") == true || jobInfo.time?.contains("刚刚") == true){
            return 0
        }

        //30天内的数据
        if (jobInfo.time?.toDate("yyyy-MM-dd")?.plus(DateSpan(30, SpanType.Day))?.after(Date()) == true){
            return 0
        }
        return 2
    }
}
