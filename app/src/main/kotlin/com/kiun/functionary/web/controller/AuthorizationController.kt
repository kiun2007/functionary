package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.sys.SysUserMapper
import com.kiun.functionary.service.SmsCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/auth")
class AuthorizationController {

    @Autowired
    val smsCodeService: SmsCodeService? = null

    @RequestMapping("send-sms")
    fun sendSms(@RequestParam phone: String) : DataWrap<Any>{

        smsCodeService?.sendCode(phone)
        return DataWrap.success("发送成功")
    }
}
