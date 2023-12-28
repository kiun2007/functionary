package com.kiun.functionary.pyspider

import com.kiun.functionary.utils.*
import java.util.Date
import java.util.LinkedList

data class SpecialityEntry(

    var name: String,

    var code: String? = null
)

data class Speciality (

    /**
     * 专业名称
     */
    var special: List<SpecialityEntry>? = null,

    /**
     * 学历
     */
    var educationName: String? = null
)

data class AgeEntry(

    /**
     * 最小年龄的出生日期
     */
    var youngBirthday: Date? = null,

    /**
     * 最大年龄的出生日期
     */
    var oldBirthday: Date? = null,

    /**
     * 学历学位
     */
    var educationName: String? = null
)

inline fun String.findAndConvert(inStr: String, nextIndex: Int, groupSize: Int, once: Boolean = false) : List<MatchGroupCollection>
{
    var lastIndex = 0
    val regex = this.toRegex()
    val list = LinkedList<MatchGroupCollection>()

    for (i in 0..1000) {
        val result = regex.find(inStr, lastIndex) ?: break
        val groups = result.groups

        if (once){
            break
        }

        if(groups.size < groupSize){
            break
        }

        val groupIndex = if(nextIndex < 0) groups.filterNotNull().size + nextIndex else nextIndex

        list.add(groups)
        lastIndex = groups[groupIndex]?.range?.last?:lastIndex
        lastIndex++
    }
    return list
}

inline fun String.specialityByGkld(): List<Speciality>?{

    var textAlls = "(专科|本科|研究生)：(.+?)(专科|本科|研究生|\$)".findAndConvert(this, 2, 3)

    if (textAlls.isEmpty()){
        textAlls = "(.*?)(.*[；、].*)".findAndConvert(this, 2, 3)
    }

    return textAlls.map { sit->

        val specialityList = sit[2]?.value?.split("[,;，；、]".toRegex())
        val specialList = LinkedList<SpecialityEntry>()

        specialityList?.filter { it.trim().isNotEmpty() }?.forEach {
            val name = "([^（A-Z0-9）]{0,16})".toRegex().find(it)?.groups?.get(1)?.value
            val code = "([A-Z0-9]{1,16})".toRegex().find(it)?.groups?.get(1)?.value
            specialList.add(SpecialityEntry(name ?: "", code))
        }
        return@map Speciality(specialList, sit[1]?.value)
    }.filterNotNull()
}

inline fun String.ageEntryByGkld(date: Date = Date()): List<AgeEntry>? {
    //50周岁以下（1973年10月8日至2005年10月8日期间出生）
    //18周岁以上，35周岁以下，具有博士学位的放宽至40周岁以下，年龄的计算时间截至2024年8月31日
    var newDate = date

    val list = this.split("，")
    val groups = list.map { "[^0-9]*([0-9\\-]*)周?岁及?以?(下|上)*(（.+?出生）)?".findAndConvert(it, 0, 3) }

    val entryList = LinkedList<AgeEntry>()
    var entry = AgeEntry()
    entryList.add(entry)

    val dateGroups = "年龄.*计算.*([0-9]{4}).?([0-9]{1,2}).?([0-9]{1,2}).?".findAndConvert(this, 3, 4)
    dateGroups.firstOrNull()?.let {
        newDate = it.toDate(sd = date)
    }

    groups.filter { it.isNotEmpty() }.forEach {

        val allText = it[0][0]?.value
        val ageNumber = it[0][1]?.value
        val maxOrMin = it[0][2]?.value
        val birthdayText = if(it[0].size > 3) it[0][3]?.value else null

        allText?.let {
            val educationGroups = ".*(专科|本科|硕士|博士).*".findAndConvert(it, 0, 2)
            if(educationGroups.isNotEmpty()){
                entry = AgeEntry()
                entry.educationName = educationGroups[0][1]?.value
                entryList.add(entry)
            }
        }

        if (birthdayText != null){
            val group = "([0-9]{4}).?([0-9]{1,2}).?([0-9]{1,2}).?(之前|之后)?.?".findAndConvert(birthdayText, -1, 3)
            if(group.size == 2){
                entry.oldBirthday = group[0].toDate(sd = newDate)
                entry.youngBirthday = group[1].toDate(sd = newDate)
            }
            else if (groups.size == 1)
            {
                val oldOrYoung = group[0][4]?.value
                if (oldOrYoung == "之前"){
                    entry.youngBirthday = group[0].toDate(sd = newDate)
                }

                if (oldOrYoung == "之后"){
                    entry.oldBirthday = group[0].toDate(sd = newDate)
                }
            }
        }
        else
        {
            if (ageNumber?.contains("-") == true){
                val ageStrs = ageNumber.split("-")
                entry.youngBirthday = newDate - DateSpan(ageStrs[0]?.toInt(), SpanType.Year)
                entry.oldBirthday = newDate - DateSpan(ageStrs[1]?.toInt(), SpanType.Year)
            } else {
                if (maxOrMin == "上"){
                    entry.youngBirthday = newDate - DateSpan(ageNumber?.toInt()?:0, SpanType.Year)
                }
                if (maxOrMin == "下"){
                    entry.oldBirthday = newDate - DateSpan(ageNumber?.toInt()?:0, SpanType.Year)
                }
            }
        }
    }
    return entryList.filter { it.oldBirthday != null || it.youngBirthday != null }
}
