package com.kiun.functionary.web.view

import com.kiun.functionary.base.general.ListBuildData
import com.kiun.functionary.base.general.ListBuildItemData
import com.kiun.functionary.service.GeneralService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class GeneralPage {

    @Autowired
    val generalService: GeneralService? = null

    @GetMapping("/general/edit/{formId}/{id}")
    fun editView(
            @PathVariable("id") id: String,
            @PathVariable("formId") formId: String,
            mmap: ModelMap?
    ): String? {

        fillPageValue(formId, mmap)
        mmap?.put("data", generalService?.getById<Any>(formId, id))
        return "general/edit"
    }

    @GetMapping("/general/add/{formId}")
    fun addView(@PathVariable("formId") formId: String, mmap: ModelMap?): String? {
        fillPageValue(formId, mmap)
        return "general/add"
    }

    @GetMapping("/general/list/{formId}")
    fun listView(@PathVariable("formId") formId: String, mmap: ModelMap?): String {

        fillPageValue(formId, mmap)
        mmap?.put("formId", formId)
        return "general/list"
    }

    private fun fillPageValue(formId: String, mmap: ModelMap?): ListBuildData?  {
        val ret = generalService?.getBuildByName(formId)
        mmap?.put("buildData", ret)
        mmap?.put("items", generalService?.listBuildItem(formId))
        return ret
    }
}
