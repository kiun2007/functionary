package com.kiun.functionary.service

import java.io.InputStream

interface ExcelService {

    /**
     * @param inputStream
     */
    fun importNotice(inputStream: InputStream, planId: String, noticeId: String): String

    fun importReview(reviewId: String): List<List<String>>?

    fun importStart(reviewId: String, copyNotice: Boolean): Boolean
}
