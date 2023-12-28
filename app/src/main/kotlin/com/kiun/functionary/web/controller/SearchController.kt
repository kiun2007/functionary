package com.kiun.functionary.web.controller

import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.base.TableDataInfo
import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.gks.SearchNoticeMapper
import com.kiun.functionary.dao.gks.entity.JobDetails
import com.kiun.functionary.dao.gks.entity.JobNotice
import com.kiun.functionary.dao.sys.SysDictItemMapper
import com.kiun.functionary.dao.sys.VSysDictItemMapper
import com.kiun.functionary.dao.sys.entity.SysDictItem
import com.kiun.functionary.dao.sys.entity.SysDictItemExample
import com.kiun.functionary.dao.sys.entity.VSysDictItem
import com.kiun.functionary.dao.sys.entity.VSysDictItemExample
import com.kiun.functionary.service.utils.DateUtil
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RequestMapping("api/search")
@RestController
class SearchController {

    @Autowired
    val searchNoticeMapper: SearchNoticeMapper? = null

    @Autowired
    val vSysDictItemMapper: VSysDictItemMapper? = null

    @RequestMapping("noticeByAttribute")
    fun noticeByAttribute(
        @RequestParam("pageSize") pageSize: Int,
        @RequestParam("pageNum") pageNum: Int,
        @RequestParam("searchType") searchType: String,
        type: String?,
        region: String?) : TableDataInfo<JobNotice> {

        val userId = AppContext.currentUser().userId
        PageHelper.startPage<Page<*>>(pageNum, pageSize)
        return TableDataInfo.success(searchNoticeMapper?.searchNoticeByUserId(userId, searchType, type, region))
    }

    @RequestMapping("jobDetailsByAttribute")
    fun jobDetailsByAttribute(
        @RequestParam("pageSize") pageSize: Int,
        @RequestParam("pageNum") pageNum: Int,
        @RequestParam("noticeId") noticeId: String
    ) : TableDataInfo<JobDetails> {

        val userId = AppContext.currentUser().userId
        PageHelper.startPage<Page<*>>(pageNum, pageSize)
        return TableDataInfo.success(searchNoticeMapper?.searchDetailsByNoticeId(userId, noticeId))
    }

    @RequestMapping("allDictByTimeLine")
    fun allDictByTimeLine(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") lastDate: Date?) : DataWrap<List<VSysDictItem>>
    {
        val dictItemExample = VSysDictItemExample()
        val criteria = dictItemExample.createCriteria()
        if (lastDate != null){
            criteria.andUpdTimeGreaterThan(lastDate)
        }
        return DataWrap.success(vSysDictItemMapper?.selectByExample(dictItemExample))
    }
}
