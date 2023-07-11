package com.kiun.functionary.config

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.sys.entity.SysUser
import com.kiun.functionary.properties.CryptProperties
import com.kiun.functionary.service.utils.writeAny
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import java.security.SecureRandom


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Autowired
    val cryptProperties: CryptProperties? = null

    @Bean
    fun filterChain(httpSecurity: HttpSecurity) : SecurityFilterChain {

        httpSecurity.authorizeHttpRequests {
            it.requestMatchers("/auth/login","/api/auth/login-form", "/api/system/user/list").permitAll()
                    .anyRequest().authenticated().apply {  }
        }.formLogin {
            it.loginPage("/auth/login")
                    .loginProcessingUrl("/api/auth/login-form")
                    .failureHandler { request, response, exception -> response.writeAny(DataWrap.fail<Any>(exception.message)) }
                    .permitAll()
                    .successHandler(
                            object : SavedRequestAwareAuthenticationSuccessHandler() {
                                override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
                                    if (request?.getHeader("Ajax") == "1"){
                                        if(authentication?.principal is SysUser){
                                            (authentication.principal as SysUser).loginPwd = null
                                        }
                                        response?.writeAny(DataWrap.success(authentication?.principal))
                                        return
                                    }
                                    super.onAuthenticationSuccess(request, response, authentication)
                                }
                            }
                    )
        }

        httpSecurity.csrf().disable()
        return httpSecurity.build()
    }

    @Bean
    fun getPwdEncoder(): PasswordEncoder? {
        if(cryptProperties?.salt != null){
            return BCryptPasswordEncoder(-1, SecureRandom(cryptProperties!!.salt!!.toByteArray()))
        }
        return BCryptPasswordEncoder()
    }
}
