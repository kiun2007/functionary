package com.kiun.functionary.service.imps

import com.aliyuncs.CommonRequest
import com.aliyuncs.DefaultAcsClient
import com.aliyuncs.IAcsClient
import com.aliyuncs.profile.DefaultProfile
import com.google.gson.Gson
import com.kiun.functionary.component.SpringUtils
import com.kiun.functionary.service.SmsCodeService
import com.kiun.functionary.service.utils.toMap
import jakarta.xml.bind.DatatypeConverter
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Service
import java.util.*

data class SmsCodeEntry(
    val code: String,
    val date: Date
)

@Service
class AliyunSmsCodeService : SmsCodeService {

    final var client : IAcsClient

    init {
        val profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FwdQojePLKMwzWFTKG6", "W9ivkOzHf7sqJComSVsEsscOP0aBJg")
        client = DefaultAcsClient(profile)
    }

    val phoneMap: MutableMap<String, SmsCodeEntry> = HashMap()

    fun sendSms(phone: String, code: String){

        val request = CommonRequest()
        request.domain = "dysmsapi.aliyuncs.com"
        request.version = "2017-05-25"
        request.action = "SendSms"
        request.putQueryParameter("PhoneNumbers", phone)
        request.putQueryParameter("SignName", "公考搜")
        request.putQueryParameter("TemplateCode", "SMS_462675948")
        request.putQueryParameter("TemplateParam", "{\"code\":\"${code}\"}")

        val response = client.getCommonResponse(request)
        val bean = SpringUtils.getBean(Gson::class.java)
        val result = bean.fromJson(response.data, Map::class.java)

        if(result["Code"] != "OK"){
            throw Exception("发送失败,${result["Message"]}")
        }
    }

    override fun sendCode(phone: String) {
        synchronized(phoneMap){
            val code = String.format("%06d", Random().nextInt(1000000))

            sendSms(phone, code)
            phoneMap.put(phone, SmsCodeEntry(code, Date()))
        }
    }

    override fun verify(phone: String, code: String) {

        if (!phoneMap.containsKey(phone)){
            throw BadCredentialsException("手机号未发送验证码")
        }

        if(phoneMap[phone]?.code != code){
            throw BadCredentialsException("验证码错误")
        }

        if((Date().time - phoneMap[phone]!!.date.time) > (10 * 1000 * 60)){
            throw BadCredentialsException("验证码已失效")
        }
        phoneMap.remove(phone)
    }
}
