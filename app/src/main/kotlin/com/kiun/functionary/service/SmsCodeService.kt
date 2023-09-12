package com.kiun.functionary.service

interface SmsCodeService {

    /**
     * 发送验证码
     */
    fun sendCode(phone: String)

    /**
     * 验证
     */
    fun verify(phone: String, code: String)
}
