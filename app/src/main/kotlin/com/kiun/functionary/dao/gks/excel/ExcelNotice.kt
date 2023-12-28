package com.kiun.functionary.dao.gks.excel

import java.util.Date

data class ExcelNotice(

    var title: String? = null,

    var details: String? = null,

    var source: String? = null,

    var url : String? = null,

    var publish: Date? = null,

    var start: Date? = null,

    var end: Date? = null,

    var province: String? = null,

    var city: String? = null,

    var type: String? = null,

    var content: String? = null
)
