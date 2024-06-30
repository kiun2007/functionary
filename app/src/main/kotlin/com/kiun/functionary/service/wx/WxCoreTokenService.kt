package com.kiun.functionary.service.wx

import com.kiun.functionary.fegin.wx.WxOpenService
import jakarta.annotation.Resource
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class WxCoreTokenService {

    /**
     * 微信小程序APi操作凭证
     */
    var miniAppToken: String? = null

    /**
     * 公众号API操作凭证
     */
    var officialToken: String? = null

    @Resource(name = "wxOpenService")
    var wxOpenService: WxOpenService? = null

    @Resource(name = "officialService")
    var officialService: WxOpenService? = null

    @Scheduled(initialDelay = 1000, fixedDelay = 4800*1000)
    fun tokenGet(){
        miniAppToken = null
        synchronized(this){
            val token = wxOpenService?.token()
            if(token?.errcode == 0){
                miniAppToken = token.access_token
            }
        }
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 4800*1000)
    fun officeTokenGet() {

        officialToken = null
        val token = officialService?.token()
        if(token?.errcode == 0){
            officialToken = token.access_token
        }
    }
}
