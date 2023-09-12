package com.kiun.functionary.base

import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.sys.SysUserMapper
import com.kiun.functionary.dao.sys.entity.SysUser
import com.kiun.functionary.service.SmsCodeService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.security.SecureRandom

class BCryptOrSmsPasswordEncoder(strength: Int = -1, random: SecureRandom? = null) : BCryptPasswordEncoder(strength, random) {

    override fun encode(rawPassword: CharSequence?): String {
        return super.encode(rawPassword)
    }
    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {

        val smsLogin = AppContext.getRequest().getHeader("sms-login")
        val threadLocal = AppContext.getBean(ThreadLocal::class.java)
        val smsCodeService = AppContext.getBean(SmsCodeService::class.java)

        if (smsLogin == "1" && threadLocal.get() is SysUser){
            val userUser = threadLocal.get() as SysUser

            val smsCode = AppContext.getRequest().getParameter("password")
            smsCodeService.verify(userUser.loginName, smsCode)

            if(userUser.isNew){
                userUser.userName = "手机用户"
                AppContext.getBean(SysUserMapper::class.java)?.insertOne(userUser)
            }
            return true
        }
        return super.matches(rawPassword, encodedPassword)
    }
}
