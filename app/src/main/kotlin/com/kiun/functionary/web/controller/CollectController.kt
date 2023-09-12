package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.gks.entity.CollectCount
import com.kiun.functionary.service.CollectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api/collect")
@RestController
class CollectController {

    @Autowired
    val collectService: CollectService? = null

    @GetMapping("count")
    fun count(): DataWrap<CollectCount>{
        return DataWrap.success(collectService?.count())
    }
}
