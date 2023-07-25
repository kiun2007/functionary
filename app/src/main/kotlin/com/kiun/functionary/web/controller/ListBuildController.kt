package com.kiun.functionary.web.controller

import com.github.pagehelper.PageInfo
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.base.TableDataInfo
import com.kiun.functionary.service.GeneralService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("generalList")
class ListBuildController {

    @Autowired
    val generalService: GeneralService? = null

    @RequestMapping("/{formId}/page")
    fun getListByPage(@PathVariable("formId") formId: String, param: Map<String, Any>): TableDataInfo<Any>{
        return TableDataInfo.success(generalService?.selectList<Any>(formId, param))
    }

    @PostMapping("/{formId}/remove")
    fun deleteById(@PathVariable("formId") formId: String, @RequestParam ids: String): DataWrap<Boolean>{
        return DataWrap.success(true)
    }

    @RequestMapping("/{formId}/save")
    fun save(@PathVariable("formId") formId: String, @RequestBody json: String): DataWrap<Boolean>{
        return DataWrap.success(generalService?.insertOrUpdateSelective(formId, json) == true);
    }
}
