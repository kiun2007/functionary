package com.kiun.functionary.service.imps

import com.kiun.functionary.dao.sys.SysDictItemMapper
import com.kiun.functionary.dao.sys.SysOrganMapper
import com.kiun.functionary.dao.sys.entity.SysDictItem
import com.kiun.functionary.dao.sys.entity.SysDictItemExample
import com.kiun.functionary.dao.sys.entity.SysOrgan
import com.kiun.functionary.service.OrganService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.LinkedList
import java.util.regex.Pattern

@Service
class OrganServiceImp : OrganService {

    @Autowired
    var organMapper : SysOrganMapper? = null

    @Autowired
    var sysDictItemMapper: SysDictItemMapper? = null

    fun regionExample(regionName: String): List<SysDictItem>? {

        val regionExample = SysDictItemExample()
        regionExample.createCriteria().andDictIdEqualTo("gks_region").addCriterion("'${regionName}' LIKE CONCAT('%', item_val, '%') OR '${regionName}' LIKE CONCAT('%', item_alias, '%')")
        return sysDictItemMapper?.selectByExample(regionExample)
    }

    fun findRegion(regions: List<String>): SysDictItem? {

        val allRegions = LinkedList<SysDictItem>()

        regions.forEach {
            regionExample(it)?.let { it1 -> allRegions.addAll(it1) }
        }

        if(allRegions.size < 2){
            return allRegions.firstOrNull()
        }

        val cityRegion = allRegions.firstOrNull { it.level == 2 }
        if(cityRegion != null){
            //优先使用地级市或同级行政
            return cityRegion
        }
        return allRegions.firstOrNull()
    }

    override fun createOrSearch(organName: String, type: String, region: String?, split: String): SysOrgan {

        if (region?.isNotEmpty() != true){
            throw Exception("区域值不能为空")
        }

        var sysOrgan: SysOrgan? = organMapper?.selectByOrganName(organName)?.firstOrNull()
        if (sysOrgan == null){
            sysOrgan = SysOrgan()
            sysOrgan.organName = organName
            sysOrgan.organType = type

            val regions = region.split("，")
            var regionItem = findRegion(regions)
            if(regionItem == null){
                //搜索标题中的 市/区/县
                regionItem = findRegion(arrayListOf(organName))
            }

            //多种方式搜索后 仍然没有值
            if(regionItem == null){
                throw Exception("搜索不到与\"${region}\"有关的数据，请确认该列是否为有效【区域】列，或在基础信息中加入\"${region}\"")
            }

            sysOrgan.rangCd = regionItem.itemKey
            sysOrgan.rangId = regionItem.id
            sysOrgan.rangName = regionItem.itemVal
            organMapper?.insertOne(sysOrgan)
        }
        return sysOrgan
    }
}
