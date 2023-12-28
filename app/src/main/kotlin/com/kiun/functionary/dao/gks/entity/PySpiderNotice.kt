package com.kiun.functionary.dao.gks.entity

import com.kiun.functionary.service.utils.set
import com.kiun.functionary.utils.pairMap

class PySpiderNotice : JobNotice() {

    /**
     * 地区
     */
    var region: String? = null

    /**
     * 单位名称
     */
    var organName: String? = null
}

data class NoticeListItem(

    var title: String?,

    var url: String?,

    var type: String?,

    var time: String?
)

class PyJobInfo : JobInfoData() {

    var mustValues : Array<String>? = null

    var infoValues : Array<String>? = null
    override fun allInfo(): Map<String, String> {

        val mustMap = mustValues!!.toList().pairMap()
        val infoMap = infoValues!!.toList().pairMap()

        infoMap.forEach{ (k, v) ->
            mustMap.put(k, v)
        }
        return mustMap
    }

    override fun importUser(): String {
        return "pyspider"
    }

    override fun importUserNm(): String {
        return "爬虫用户"
    }
}

class ExcelJobInfo(
    noticeId: String? = null,
    val headList: List<String>,
    val dataList : List<String>
) : JobInfoData(
    noticeId = noticeId
) {
    init {
        recruitNum = allInfo()["recruitNum"]
    }

    override fun allInfo(): Map<String, String> {

        val map = HashMap<String, String>()
        for (i in headList.indices){
            map.put(headList[i], dataList[i])
        }
        return map
    }

    override fun importUser(): String {
        return "excel-import"
    }

    override fun importUserNm(): String {
        return "Excel导入用户"
    }

}

abstract class JobInfoData(
    var sourceUrl: String? = null,

    var noticeId: String? = null,

    var recruitNum: String? = null,

    var title: String? = null
) {
    abstract fun allInfo(): Map<String, String>

    abstract fun importUser(): String
    abstract fun importUserNm(): String
}
