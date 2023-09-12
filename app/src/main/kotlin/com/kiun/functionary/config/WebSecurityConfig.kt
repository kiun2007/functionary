package com.kiun.functionary.config

import com.kiun.functionary.base.BCryptOrSmsPasswordEncoder
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.sys.entity.SysUser
import com.kiun.functionary.properties.CryptProperties
import com.kiun.functionary.service.security.MySqlUserDetailService
import com.kiun.functionary.service.utils.writeAny
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import java.security.SecureRandom


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class WebSecurityConfig {

    @Autowired
    val cryptProperties: CryptProperties? = null

    @Bean
    open fun filterChain(httpSecurity: HttpSecurity) : SecurityFilterChain {

        httpSecurity.authorizeHttpRequests {
            it.requestMatchers(
                    "/auth/login",
                    "/api/auth/login-form",
                    "/api/auth/send-sms",
                    "/api/system/user/list",
                    "/generalList/**",
                    "/css/**",
                    "/docs/**",
                    "/fonts/**",
                    "/img/**",
                    "/ajax/**",
                    "/js/**",
                    "/ruoyi/**",
                    "/druid/**").permitAll()
                    .anyRequest().authenticated().apply {  }
        }.formLogin {
            it.loginPage("/auth/login")
                    .loginProcessingUrl("/api/auth/login-form")
                    .failureHandler { request, response, exception ->
                        response.writeAny(DataWrap.fail<Any>(exception.message))
                    }
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

        httpSecurity.headers().frameOptions().disable()
        httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint { request, response, ex ->
            if (request?.getHeader("Ajax") == "1"){
                response.status = 401
                response.writeAny(DataWrap("未登录", null, 401))
            }else{
                response.sendRedirect("/auth/login")
            }
        }
        return httpSecurity.build()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder? {
        if(cryptProperties?.salt != null){
            return BCryptOrSmsPasswordEncoder(-1, SecureRandom(cryptProperties!!.salt!!.toByteArray()))
        }
        return BCryptOrSmsPasswordEncoder()
    }
}
