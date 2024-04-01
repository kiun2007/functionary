package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.base.TableDataInfo
import com.kiun.functionary.service.ImportData
import com.kiun.functionary.service.ImportDataList
import com.kiun.functionary.service.ImportError
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
    fun importStart(@PathVariable reviewId: String, @RequestParam(required = false) copyNotice: Boolean = true): DataWrap<Any>{
        easyExcelService?.importStart(reviewId, true)
        return DataWrap.success(true)
    }
    @GetMapping("stopImport/{reviewId}")
    fun stopImport(@PathVariable reviewId: String): DataWrap<Any>{
        easyExcelService?.stopImport(reviewId)
        return DataWrap.success(true)
    }

    @GetMapping("deleteImport/{reviewId}")
    fun deleteImport(@PathVariable reviewId: String): DataWrap<Any>{

        easyExcelService?.deleteImport(reviewId)
        return DataWrap.success(true)
    }

    @GetMapping("importAnswer/{reviewId}")
    fun importAnswer(@PathVariable reviewId: String, @RequestParam content: String): DataWrap<Any>{
        easyExcelService?.answer(reviewId, content)
        return DataWrap.success(true)
    }

    @RequestMapping("importRecord")
    fun importRecord(pageNum: Int, pageSize: Int): TableDataInfo<ImportDataList> {

        val recordList = easyExcelService?.allImportRecord() ?: throw Exception("数据错误")

        val startIndex = recordList.size.coerceAtMost((pageNum - 1) * pageSize)
        val toIndex = recordList.size.coerceAtMost(pageNum * pageSize)
        return TableDataInfo(total = recordList?.size?.toLong() ?: 0L, rows = recordList.subList(startIndex, toIndex).map { it.toListItem() })
    }

    @RequestMapping("importError/{reviewId}")
    fun importError(@PathVariable("reviewId") reviewId: String, pageNum: Int, pageSize: Int): TableDataInfo<ImportError> {

        val errorList = easyExcelService?.recordById(reviewId)?.errorList ?: throw Exception("数据错误")

        synchronized(errorList){
            val startIndex = errorList.size.coerceAtMost((pageNum - 1) * pageSize)
            val toIndex = errorList.size.coerceAtMost(pageNum * pageSize)
            return TableDataInfo(total = errorList.size.toLong() ?: 0L, rows = errorList.subList(startIndex, toIndex))
        }
    }
}
