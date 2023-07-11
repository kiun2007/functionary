package com.kiun.functionary.service.security

import com.kiun.functionary.dao.sys.SysUserMapper
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

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username?.trim() == ""){
            throw UsernameNotFoundException("请输入有效的用户名")
        }

        val user = sysUserMapper?.selectByLoginName(username)
        if((user == null) || user.isEmpty()){
            throw UsernameNotFoundException("用户不存在")
        }
        return user[0];
    }
}
