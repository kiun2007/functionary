package com.kiun.functionary.utils

import com.kiun.functionary.dao.gks.entity.ImportPlanColumn


inline fun ImportPlanColumn.format(item: Map<Int, String?>, head: Map<Int, String?>?): String? {

    //小于0表示常量
    if(this.columnIndex < 0){
        return JexlUtil.exec(columnFormat, mapOf("row" to item))?.toString()
    }

    if(!item.containsKey(this.columnIndex)){
        throw Exception("方案与文档不符")
    }

    val index = if(columnField?.isNotEmpty() == true && head?.hasValue(columnField) == true) head.getKey(columnField) else (this.columnIndex?:0)
    val value = item[index]
    return if(columnFormat?.isNotEmpty() == true){
        JexlUtil.exec(columnFormat, mapOf("cell" to value))?.toString()
    } else {
        value
    }
}
