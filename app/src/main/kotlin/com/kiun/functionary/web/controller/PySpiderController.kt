package com.kiun.functionary.web.controller

import com.google.common.base.Verify
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.gks.entity.JobDetails
import com.kiun.functionary.dao.gks.entity.NoticeListItem
import com.kiun.functionary.dao.gks.entity.PyJobInfo
import com.kiun.functionary.dao.gks.entity.PySpiderNotice
import com.kiun.functionary.service.PySpiderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api/pyspider")
@RestController
class PySpiderController {

    @Autowired
    lateinit var pySpiderService : PySpiderService

    @PostMapping("/createNotice")
    fun createNotice(@RequestBody notice: PySpiderNotice): DataWrap<String> {
        val noticeId = pySpiderService.createNotice(notice) ?: return DataWrap.fail("类型不支持")
        return DataWrap.success(noticeId)
    }

    @PostMapping("/createJobInfo")
    fun createJobInfo(@RequestBody jobInfo: PyJobInfo) : DataWrap<String> {
        return DataWrap.success(pySpiderService.createJobDetails(jobInfo))
    }

    /**
     * 验证公告是否可录入
     */
    @PostMapping("/verifyNotice")
    fun verifyNotice(@RequestBody verify: NoticeListItem) : DataWrap<Int> {
        return DataWrap.success(pySpiderService.verifyNotice(verify));
    }
}
