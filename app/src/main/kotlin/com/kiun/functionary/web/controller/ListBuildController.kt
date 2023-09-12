package com.kiun.functionary.web.controller

import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.base.TableDataInfo
import com.kiun.functionary.service.GeneralService
import com.kiun.functionary.service.utils.toJson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("generalList")
class ListBuildController {

    @Autowired
    val generalService: GeneralService? = null

    @RequestMapping("/{formId}/page")
    fun getListByPage(
            @PathVariable("formId") formId: String,
            @RequestParam("pageSize") pageSize: Int,
            @RequestParam("pageNum") pageNum: Int,
            @RequestParam param: MutableMap<String, Any>
    ): TableDataInfo<Any>{

        PageHelper.startPage<Page<*>>(pageNum, pageSize)
        param.remove("pageSize")
        param.remove("pageNum")

        param.filter { it.value == "" }.map { it.key }.forEach{
            param.remove(it)
        }
        return TableDataInfo.success(generalService?.selectList(formId, param))
    }

    @RequestMapping("/{formId}/list")
    fun getList(
            @PathVariable("formId") formId: String,
            @RequestParam param: MutableMap<String, Any>
    ): DataWrap<List<Any>?>{

        param.filter { it.value == "" }.map { it.key }.forEach{
            param.remove(it)
        }
        return DataWrap.success(generalService?.selectList(formId, param))
    }

    @RequestMapping("/{formId}/array")
    fun getListArray(
            @PathVariable("formId") formId: String,
            @RequestParam param: MutableMap<String, Any>
    ): List<Any>?{

        param.filter { it.value == "" }.map { it.key }.forEach{
            param.remove(it)
        }
        return generalService?.selectList(formId, param)
    }

    @PostMapping("/{formId}/remove")
    fun deleteById(
            @PathVariable("formId") formId: String,
            @RequestParam ids: String
    ): DataWrap<Boolean>{

        return DataWrap.success(true)
    }

    @GetMapping("/{formId}/removeQuery")
    fun removeQuery(
            @PathVariable("formId") formId: String,
            @RequestParam param: MutableMap<String, Any>
    ): DataWrap<Boolean>{
        return DataWrap.success(generalService?.delete(formId, param))
    }

    @RequestMapping("/{formId}/save")
    fun save(@PathVariable("formId") formId: String, @RequestBody json: String): DataWrap<Boolean>{
        return DataWrap.success(generalService?.insertOrUpdateSelective(formId, json) == true);
    }

    @RequestMapping("/{formId}/edit")
    fun edit(@PathVariable("formId") formId: String, @RequestBody json: String): DataWrap<Boolean>{
        return DataWrap.success(generalService?.update(formId, json) == true);
    }

    @PostMapping("/{formId}/add")
    fun addPost(@PathVariable("formId") formId: String, @RequestBody json: String): DataWrap<Boolean>{
        return DataWrap.success(generalService?.insert(formId, json) == true);
    }

    @GetMapping("/{formId}/add")
    fun addGet(
            @PathVariable("formId") formId: String,
            @RequestParam param: MutableMap<String, Any>
    ): DataWrap<Boolean>{
        return DataWrap.success(generalService?.insert(formId, param.toJson()) == true);
    }
}
