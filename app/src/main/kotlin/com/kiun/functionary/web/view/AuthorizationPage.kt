package com.kiun.functionary.web.view

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@EnableMethodSecurity
class AuthorizationPage {

    @RequestMapping("/")
    fun index(): String{
        return "index"
    }

    @GetMapping("auth/login")
    fun login() = "login"
}
