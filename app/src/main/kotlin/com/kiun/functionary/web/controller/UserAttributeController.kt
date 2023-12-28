package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.gks.AgencyRecordMapper
import com.kiun.functionary.dao.gks.entity.UserAttribute
import com.kiun.functionary.service.UserAttributeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RequestMapping("api/userAttribute")
@RestController
class UserAttributeController {

    @Autowired
    val userAttributeService: UserAttributeService? = null

    @Autowired
    val agencyRecordService: AgencyRecordMapper? = null

    @PostMapping("save")
    fun save(@RequestBody attriList: List<UserAttribute>): DataWrap<List<UserAttribute>>
    {
        return DataWrap.success(userAttributeService?.save(attriList))
    }

    @PostMapping("replace")
    fun replace(@RequestBody attriList: List<UserAttribute>): DataWrap<List<UserAttribute>>
    {
        return DataWrap.success(userAttributeService?.replace(attriList))
    }

    @RequestMapping("getByDict")
    fun getByDict(@RequestParam dictId: String): DataWrap<List<UserAttribute>>
    {
        return DataWrap.success(userAttributeService?.getByDict(dictId))
    }

    @RequestMapping("all")
    fun all(): DataWrap<List<UserAttribute>>
    {
        return DataWrap.success(userAttributeService?.getByDict())
    }
}
