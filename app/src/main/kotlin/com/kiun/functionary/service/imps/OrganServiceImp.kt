package com.kiun.functionary.service.imps

import com.kiun.functionary.dao.sys.SysDictItemMapper
import com.kiun.functionary.dao.sys.SysOrganMapper
import com.kiun.functionary.dao.sys.entity.SysDictItemExample
import com.kiun.functionary.dao.sys.entity.SysOrgan
import com.kiun.functionary.service.OrganService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrganServiceImp : OrganService {

    @Autowired
    var organMapper : SysOrganMapper? = null

    @Autowired
    var sysDictItemMapper: SysDictItemMapper? = null

    override fun createOrSearch(organName: String, type: String, region: String?, split: String): SysOrgan {

        var sysOrgan: SysOrgan? = organMapper?.selectByOrganName(organName)?.firstOrNull()
        if (sysOrgan == null){
            sysOrgan = SysOrgan()
            sysOrgan.organName = organName
            val regions = region?.split("，")

            if(regions?.size == 1){
                val regionExample = SysDictItemExample()
                regionExample.createCriteria().andItemValLike("${regions[0].trim()}%").andDictIdEqualTo("gks_region")
                regionExample.or().andItemAliasLike("${regions[0].trim()}%").andDictIdEqualTo("gks_region")

                val regionResult = sysDictItemMapper?.selectByExample(regionExample)?.firstOrNull()
                regionResult?.let {
                    sysOrgan.rangCd = it.itemKey
                    sysOrgan.rangId = it.id
                    sysOrgan.rangName = it.itemVal
                }
            } else if (regions?.size!! > 1){
                val regionExample = SysDictItemExample()
                regionExample.createCriteria().andItemValLike(regions[1].trim()).andDictIdEqualTo("gks_region")
                regionExample.or().andItemAliasLike(regions[1].trim()).andDictIdEqualTo("gks_region")

                //区域
                val regionResult = sysDictItemMapper?.selectByExample(regionExample)
                if (regionResult?.size == 1){
                    sysOrgan.rangCd = regionResult[0].itemKey
                    sysOrgan.rangId = regionResult[0].id
                    sysOrgan.rangName = regionResult[0].itemVal
                } else if (regionResult != null && regionResult!!.size > 1){
                    //TODO 如果存在多个应该查找上级
                }
            }

            sysOrgan.organType = type
            organMapper?.insertOne(sysOrgan)
        }
        return sysOrgan
    }
}
