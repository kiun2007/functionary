package com.kiun.functionary.service.amap

import com.kiun.functionary.dao.sys.SysDictItemMapper
import com.kiun.functionary.dao.sys.entity.SysDictItem
import com.kiun.functionary.dao.sys.entity.SysDictItemExample
import com.kiun.functionary.fegin.wx.AmapOpenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.*
import kotlin.time.times


@Component
class AmapService {

    @Autowired
    val amapOpenService: AmapOpenService? = null

    @Autowired
    val sysDictItemMapper: SysDictItemMapper? = null

//    @Scheduled(initialDelay = 1000, fixedDelay = 4800*1000)
    fun regionFlush(){

        val sysDictItemExample = SysDictItemExample()
        sysDictItemExample.createCriteria().andDictIdEqualTo("gks_region").addCriterion("level =", 2, "level");

        val items = sysDictItemMapper?.selectByExample(sysDictItemExample)

        items?.forEach{
            val result = amapOpenService?.district(it.itemVal)
            val districts = result?.districts?.firstOrNull()?.districts

            var index = 1
            districts?.forEach { dit->
                val newItem = SysDictItem()
                newItem.parentId = it.id
                newItem.dictId = "gks_region"
                newItem.level = 3
                newItem.itemVal = dit.name
                newItem.itemKey = dit.adcode
                newItem.itemOrder = it.itemOrder * 100 + (index ++)

                if(newItem.itemVal.length == 2){
                    newItem.itemAlias = newItem.itemVal
                } else {
                    newItem.itemAlias = newItem.itemVal.replace(Regex("市|县|区"), "")
                }

                newItem.addUserId = "0"
                newItem.addUserNm = "admin"
                newItem.updUserId = "0"
                newItem.updUserNm = "admin"
                newItem.addTime = Date()
                newItem.updTime = Date()

                try {
                    sysDictItemMapper?.insertOne(newItem)
                }catch (e:Throwable){
                }
            }
        }
    }
}
