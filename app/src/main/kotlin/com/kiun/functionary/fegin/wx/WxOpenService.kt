package com.kiun.functionary.fegin.wx

import com.kiun.functionary.fegin.wx.entry.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

interface WxOpenService {

    /**
     * 获取接口调用凭据
     */
    @GetExchange("cgi-bin/token")
    fun token(
        @RequestParam("grant_type") grantType: String = "client_credential",
    ) : AccessToken

    @GetExchange("cgi-bin/ticket/getticket")
    fun getTicket(
        @RequestParam("type") grantType: String = "jsapi"
    ) : WxTicket

    /**
     * 小程序登录
     */
    @HttpExchange("sns/jscode2session", method = "GET", contentType = MediaType.TEXT_PLAIN_VALUE)
    fun jscode2session(
        @RequestParam("js_code") js_code: String,
        @RequestParam("grant_type") grant_type: String = "authorization_code"
    ) : String

    /**
     * 获取验证手机号
     */
    @PostExchange("wxa/business/getuserphonenumber")
    fun getuserphonenumber(
        @RequestBody request: PhoneRequest
    ) : PhoneInfoResponse
}
