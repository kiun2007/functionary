package com.kiun.functionary.web.view

import com.kiun.functionary.base.general.ListBuildItemData
import com.kiun.functionary.base.general.SelectData
import com.kiun.functionary.dao.gks.ImportPlanMapper
import com.kiun.functionary.service.ExcelService
import com.kiun.functionary.utils.ConstValue.Companion.Titles
import com.kiun.functionary.utils.pairMap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import java.util.LinkedList


@Controller
class ExcelPage {

    @Autowired
    val planMapper: ImportPlanMapper? = null

    @Autowired
    val excelService: ExcelService? = null

    @GetMapping("/excel/importNotice")
    fun importNotice(mmap: ModelMap): String{

        mmap["planItems"] = planMapper?.selectByExample(null)
        mmap["selectData"] = ListBuildItemData(selectOpt = SelectData(
            label = "noticeName",
            formLabel = "title",
            formValue = "id",
            url = "/general/select-list/VJobNoticeSelect?inputType=1"),
            title = "公告",
            value = "noticeId",
            flag = 0
        )
        return "excel/upload"
    }

    @GetMapping("/excel/importReview/{reviewId}")
    fun importReview(@PathVariable reviewId: String, mmap: ModelMap): String{

        val list = excelService?.importReview(reviewId)
        val newHead = list?.get(0)?.map { Titles.toList().pairMap()[it]!! }

        val newList = LinkedList<List<String>>()
        newList.add(newHead!!)
        newList.addAll(list?.subList(1, Math.min(10, list.size)))
        mmap["list"] = newList
        mmap["reviewId"] = reviewId
        return "excel/import-review"
    }

    @GetMapping("/excel/importRecord")
    fun allImportRecord(mmap: ModelMap): String {
        return "excel/import-record"
    }

    @GetMapping("/excel/importError")
    fun importError(@RequestParam("reviewId") reviewId: String, mmap: ModelMap): String {

        val reviewData = excelService?.recordById(reviewId)

        mmap["reviewId"] = reviewId
        mmap["header"] = reviewData?.dataList?.firstOrNull()
        return "excel/import-error"
    }
}
