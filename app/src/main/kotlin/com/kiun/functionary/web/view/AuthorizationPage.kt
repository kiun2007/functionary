package com.kiun.functionary.web.view

import com.kiun.functionary.context.AppContext
import com.kiun.functionary.service.ruoyi.SysMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@EnableMethodSecurity
class AuthorizationPage {

    @Autowired
    private val menuService: SysMenuService? = null

    @RequestMapping("/")
    fun index(mmap: ModelMap): String{
        val user = AppContext.currentUser()
        val menus = menuService?.selectMenusByUser(user)
        mmap["menus"] = menus
        mmap["user"] = user
        return "index"
    }

    @GetMapping("auth/login")
    fun login() = "login"
}
