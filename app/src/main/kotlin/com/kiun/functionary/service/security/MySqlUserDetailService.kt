package com.kiun.functionary.service.security

import com.google.gson.Gson
import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.sys.SysUserMapper
import com.kiun.functionary.dao.sys.entity.SysUser
import com.kiun.functionary.fegin.wx.WxOpenService
import com.kiun.functionary.fegin.wx.entry.MiniAppLoginResponse
import com.kiun.functionary.fegin.wx.entry.PhoneRequest
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MySqlUserDetailService : UserDetailsService {

    @Resource
    val sysUserMapper: SysUserMapper? = null

    @Autowired
    var wxOpenService: WxOpenService? = null

    @Autowired
    val threadLocal: ThreadLocal<Any>? = null

    override fun loadUserByUsername(username: String): UserDetails {

        if (username.trim() == ""){
            throw UsernameNotFoundException("请输入有效的用户名")
        }
        val smsLogin = AppContext.getRequest().getHeader("sms-login")

        //微信首次登录
        if (smsLogin == "2") {

            val code = AppContext.getRequest().getParameter("password")
            val data = wxOpenService?.jscode2session(code)
            val openidResponse = Gson().fromJson(data, MiniAppLoginResponse::class.java)
            val phoneResponse = wxOpenService?.getuserphonenumber(PhoneRequest(code = username))

            if (phoneResponse?.errcode != 0){
                throw UsernameNotFoundException(phoneResponse?.errmsg ?: "微信登录失败")
            }

            val phoneNumber = phoneResponse.phone_info?.phoneNumber
            val newUser = sysUserMapper?.selectByLoginName(phoneNumber)?.firstOrNull() ?: SysUser()

            newUser.salt = openidResponse.openid
            newUser.loginName = phoneNumber
            newUser.loginPwd = "WeChat Login"
            threadLocal?.set(newUser)
            return newUser
        }

        if (smsLogin == "3") {
            val code = AppContext.getRequest().getParameter("password")
            val data = wxOpenService?.jscode2session(code)
            val openidResponse = Gson().fromJson(data, MiniAppLoginResponse::class.java)

            if (openidResponse?.errcode != 0){
                throw UsernameNotFoundException(openidResponse?.errmsg ?: "微信登录失败")
            }

            return sysUserMapper?.selectBySalt(openidResponse.openid)?.firstOrNull()
                ?: throw UsernameNotFoundException("微信用户不存在")
        }

        val user = sysUserMapper?.selectByLoginName(username)
        if(user.isNullOrEmpty()){

            //手机注册并登录
            if (smsLogin == "1"){
                if (username.matches(Regex("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}\$"))){
                    val newUser = SysUser()
                    newUser.loginName = username
                    newUser.loginPwd = "SMS Code Login"
                    threadLocal?.set(newUser)
                    return newUser
                }
            }
            throw UsernameNotFoundException("用户不存在")
        }
        threadLocal?.set(user[0])
        return user[0];
    }
}
