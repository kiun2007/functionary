package com.kiun.functionary.web.controller

import com.github.pagehelper.PageInfo
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.base.TableDataInfo
import com.kiun.functionary.base.anno.StartPage
import com.kiun.functionary.service.GeneralService
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/general")
class GeneralController {

    @Resource(name = "http")
    val generalService: GeneralService? = null

    @StartPage
    @GetMapping("{tableName}/listOfPage")
    fun listOfPage(@PathVariable("tableName") tableName: String, @RequestParam req: Map<String, Any>): TableDataInfo<Any>{
        val list = generalService?.selectList<Any>(tableName, req) ?: return TableDataInfo.fail("未查询到数据")
        return TableDataInfo.success(list)
    }

    @GetMapping("{tableName}/list")
    fun list(@PathVariable("tableName") tableName: String, @RequestParam req: Map<String, Any>) : DataWrap<List<Any>?>{
        val list = generalService?.selectList<Any>(tableName, req) ?: return DataWrap.fail("未查询到数据")
        return DataWrap.success(list)
    }

    @PostMapping("{tableName}/insertOrUpdate")
    fun insertOrUpdate(@PathVariable("tableName") tableName: String, @RequestBody req: String) : DataWrap<Boolean> {

        var ret = false
        try {
            ret = generalService?.insertOrUpdateSelective(tableName, req)?:false
        }catch (ex: Exception){
            ret = generalService?.update(tableName, req)?:false
        }
        return DataWrap.success(ret)
    }

    @PostMapping("{tableName}/insert")
    fun insert(@PathVariable("tableName") tableName: String, @RequestBody req: String) : DataWrap<Boolean> {
        return DataWrap.success(generalService?.insert(tableName, req))
    }

    @GetMapping("{tableName}/getByKey")
    fun getByKey(@PathVariable("tableName") tableName: String, @RequestParam req: MutableMap<String, Any>) : DataWrap<Any>{
        return DataWrap.success(generalService?.getById<Any>(tableName, req))
    }

    @GetMapping("{tableName}/getOne")
    fun getOne(@PathVariable("tableName") tableName: String, @RequestParam req: MutableMap<String, Any>) : DataWrap<Any>{
        return DataWrap.success(generalService?.selectList<Any>(tableName, req)?.firstOrNull())
    }


    @RequestMapping("{tableName}/remove")
    fun remove(@PathVariable("tableName") tableName: String, @RequestParam req: MutableMap<String, Any>) : DataWrap<Boolean> {
        return DataWrap.success(generalService?.delete(tableName, req))
    }
}
