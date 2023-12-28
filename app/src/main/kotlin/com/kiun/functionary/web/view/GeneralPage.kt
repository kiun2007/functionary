package com.kiun.functionary.web.view

import com.google.gson.Gson
import com.kiun.functionary.base.general.ListBuildData
import com.kiun.functionary.base.general.ListBuildItemData
import com.kiun.functionary.service.GeneralService
import com.kiun.functionary.service.utils.toMap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Controller
class GeneralPage {

    @Autowired
    val generalService: GeneralService? = null

    @GetMapping("/general/edit/{formId}")
    fun editView(
            @PathVariable("formId") formId: String,
            @RequestParam req: MutableMap<String, Any>,
            mmap: ModelMap?
    ): String? {

        fillPageValue(formId, mmap)
        mmap?.put("data", generalService?.getById<Any>(formId, req)?.toMap())
        return "general/edit"
    }

    @GetMapping("/general/add/{formId}")
    fun addView(
            @PathVariable("formId") formId: String,
            @RequestParam initRequest: MutableMap<String, Any>?,
            mmap: ModelMap?): String? {
        fillPageValue(formId, mmap)
        mmap?.put("initRequest", initRequest)
        return "general/add"
    }

    @GetMapping("/general/tree/{formId}")
    fun treeView(@PathVariable("formId") formId: String,
                 @RequestParam("code") code: String,
                 @RequestParam("parentCode") parentCode: String,
                 @RequestParam initRequest: MutableMap<String, Any>?,
                 mmap: ModelMap?): String?{

        fillPageValue(formId, mmap)
        mmap?.put("codeName", code)
        mmap?.put("parentCodeName", parentCode)

        initRequest?.remove("parentCode")
        initRequest?.remove("code")
        mmap?.put("initRequest", initRequest)
        return "general/tree"
    }

    @GetMapping("/general/select-tree/{formId}")
    fun selectTreeView(@PathVariable("formId") formId: String,
                 @RequestParam("code") code: String,
                 @RequestParam("parentCode") parentCode: String,
                 @RequestParam initRequest: MutableMap<String, Any>?,
                 mmap: ModelMap?): String?{

        fillPageValue(formId, mmap)
        mmap?.put("codeName", code)
        mmap?.put("parentCodeName", parentCode)

        initRequest?.remove("parentCode")
        initRequest?.remove("code")
        mmap?.put("initRequest", initRequest)
        return "general/tree"
    }

    @GetMapping("/general/list/{formId}")
    fun listView(
            @PathVariable("formId") formId: String,
            @RequestParam initRequest: MutableMap<String, Any>?,
            mmap: ModelMap?): String {

        fillPageValue(formId, mmap)
        mmap?.put("formId", formId)
        mmap?.put("initRequest", initRequest)
        return "general/list"
    }

    @GetMapping("/general/select-list/{formId}")
    fun selectListView(
            @PathVariable("formId") formId: String,
            @RequestParam initRequest: MutableMap<String, Any>?,
            mmap: ModelMap?): String {

        fillPageValue(formId, mmap)
        mmap?.put("formId", formId)
        mmap?.put("initRequest", initRequest)
        return "general/select-list"
    }

    private fun fillPageValue(formId: String, mmap: ModelMap?): ListBuildData?  {
        val ret = generalService?.getBuildByName(formId)
        mmap?.put("buildData", ret)
        mmap?.put("items", generalService?.listBuildItem(formId))
        return ret
    }
}
