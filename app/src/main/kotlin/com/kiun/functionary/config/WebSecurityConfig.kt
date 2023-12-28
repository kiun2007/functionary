package com.kiun.functionary.config

import com.kiun.functionary.base.BCryptOrSmsPasswordEncoder
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.sys.entity.SysUser
import com.kiun.functionary.properties.CryptProperties
import com.kiun.functionary.service.utils.writeAny
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import java.security.SecureRandom
import java.util.*


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
                    "/app",
                    "/auth/login",
                    "/api/auth/login-form",
                    "/api/auth/send-sms",
                    "/api/auth/agency",
                    "/api/wx/getTicket",
                    "/api/system/user/list",
                    "/api/search/allDictByTimeLine",
                    "/api/general/SysLog/**", //允许任何情况记录日志
                    "/api/pyspider/*", //允许pyspider 接口访问
                    "/api/wx/*", //允许WX 接口访问
                    "/1D7N5m7ggN.txt", //允许WX 验证文本
                    "/MP_verify_qRCE1kavkXN7hW4i.txt", //允许WX 验证文本
                    "/app/MP_verify_qRCE1kavkXN7hW4i.txt", //允许WX 验证文本
                    "/generalList/**",
                    "/api/general/SysDictItem/**",
                    "/api/general/VRootDictItem/**",
                    "/api/file/**",
                    "/css/**",
                    "/static/**",
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

        httpSecurity.headers().addHeaderWriter { request, response ->
            response?.setHeader("Access-Control-Allow-Origin", "*");
            response?.setHeader("X-Frame-Options", "SAMEORIGIN");
            response?.setHeader("Access-Control-Allow-Credentials","true");
            response?.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response?.setHeader("Access-Control-Max-Age", "31536000");
            response?.setHeader("Access-Control-Allow-Headers", "*");
            if ("OPTIONS" == request.method.uppercase(Locale.getDefault())) {
                response?.status = HttpServletResponse.SC_OK;
            }
        }
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
