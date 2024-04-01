package com.kiun.functionary.fegin.wx

import com.kiun.functionary.fegin.wx.entry.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

data class AmapResult<T>(
    var status: Int? = null,
    var info: String? = null,
    var count: Int? = null,
    var districts: List<T>? = null
)

data class District(
    var adcode: String? = null,
    var name: String? = null,
    var center: String? = null,
    var level: String? = null,
    var districts: List<District>? = null)

interface AmapOpenService {

    /**
     * 获取接口调用凭据
     */
    @GetExchange("config/district")
    fun district(
        @RequestParam("keywords") keywords: String,
        @RequestParam("subdistrict") subdistrict: Int = 1,
        @RequestParam("key") key: String = "0370420699c52261fd17f623f583fbc9"
    ) : AmapResult<District>
}
