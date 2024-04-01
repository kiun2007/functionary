package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.gks.ImportPlanColumnMapper
import com.kiun.functionary.dao.gks.ImportPlanMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/import-plan")
class ImportPlanController {

    @Autowired
    private val importPlanMapper: ImportPlanMapper? = null

    @Autowired
    private val importPlanColumnMapper: ImportPlanColumnMapper? = null

    @GetMapping("clone")
    fun clone(@RequestParam("id") id: String) : DataWrap<Boolean> {

        val importPlan = importPlanMapper?.selectByPrimaryKey(id)
        val columnList = importPlanColumnMapper?.selectByPlanId(id)

        importPlan?.flushId()
        importPlan?.title += "复制"
        importPlanMapper?.insertOne(importPlan)

        columnList?.forEach {
            it.flushId()
            it.planId = importPlan?.id
            importPlanColumnMapper?.insertOne(it)
        }
        return DataWrap.success()
    }
}
