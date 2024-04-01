package com.kiun.functionary.web.view

import com.kiun.functionary.base.general.ListBuildItemData
import com.kiun.functionary.base.general.SelectData
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AppPage {
    @GetMapping("/app")
    fun mainPage(mmap: ModelMap): String{

        return "app/index"
    }


}
