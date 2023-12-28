package com.kiun.functionary.service

import com.kiun.functionary.dao.gks.entity.*

interface PySpiderService {
    fun createNotice(notice: PySpiderNotice) : String?

    fun createJobDetails(jobInfo: JobInfoData) : String

    fun verifyNotice(jobInfo: NoticeListItem) : Int
}
