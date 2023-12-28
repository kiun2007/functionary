package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.service.imps.EasyExcelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RequestMapping("api/excel")
@RestController
class ExcelController {

    @Autowired
    var easyExcelService: EasyExcelService? = null

    @PostMapping("importNotice")
    fun importNotice(
        @RequestParam file_data: MultipartFile,
        @RequestParam planId: String,
        @RequestParam noticeId: String) : DataWrap<String>{

        return DataWrap.success(easyExcelService?.importNotice(file_data.inputStream, planId, noticeId))
    }

    @GetMapping("importStart/{reviewId}")
    fun importStart(@PathVariable reviewId: String,
                    @RequestParam(required = false) copyNotice: Boolean = true
    ): DataWrap<Any>{
        return DataWrap.success(easyExcelService?.importStart(reviewId, true))
    }
}
