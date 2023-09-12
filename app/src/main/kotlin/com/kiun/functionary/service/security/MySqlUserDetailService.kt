package com.kiun.functionary.service.security

import com.kiun.functionary.dao.sys.SysUserMapper
import com.kiun.functionary.dao.sys.entity.SysUser
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
    val threadLocal: ThreadLocal<Any>? = null

    override fun loadUserByUsername(username: String?): UserDetails {

        if (username?.trim() == ""){
            throw UsernameNotFoundException("请输入有效的用户名")
        }

        val user = sysUserMapper?.selectByLoginName(username)
        if(user.isNullOrEmpty()){

            if (username?.matches(Regex("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}\$")) == true){
                val newUser = SysUser()
                newUser.loginName = username
                newUser.loginPwd = "SMS Code Login"
                threadLocal?.set(newUser)
                return newUser
            }
            throw UsernameNotFoundException("用户不存在")
        }
        threadLocal?.set(user[0])
        return user[0];
    }
}
