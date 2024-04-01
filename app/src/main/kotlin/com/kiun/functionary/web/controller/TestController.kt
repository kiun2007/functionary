package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.gks.entity.PySpiderNotice
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api")
@RestController
class TestController {

    @RequestMapping("/leida")
    fun createNotice(request: HttpServletRequest) {
        var a = 0;
    }
}
