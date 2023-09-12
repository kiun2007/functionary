package com.kiun.functionary.service.imps

import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.gks.UserAttributeMapper
import com.kiun.functionary.dao.gks.entity.UserAttribute
import com.kiun.functionary.dao.gks.entity.UserAttributeExample
import com.kiun.functionary.service.UserAttributeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserAttributeServiceImp : UserAttributeService {

    @Autowired
    val userAttributeMapper: UserAttributeMapper? = null

    override fun save(attriList: List<UserAttribute>): List<UserAttribute> {
        val user = AppContext.currentUser()
        attriList.forEach{

            it.userId = user.id
            if(it.isNew()){
                it.fillId()
                userAttributeMapper?.insertOne(it)
            }else{
                userAttributeMapper?.updateByPrimaryKey(it)
            }
        }
        return attriList;
    }

    override fun replace(attriList: List<UserAttribute>): List<UserAttribute> {
        val user = AppContext.currentUser()

        val dictIds = attriList.map { it.dictId }.distinct()
        val tags = attriList.map { it.tag }.distinct()
        val example = UserAttributeExample()
        example.createCriteria().andDictIdIn(dictIds).andUserIdEqualTo(user.id).andTagIn(tags)
        userAttributeMapper?.deleteByExample(example)

        attriList.forEach{
            it.userId = user.id
            it.fillId()
            userAttributeMapper?.insertOne(it)
        }
        return attriList
    }

    override fun getByDict(dictId: String?): List<UserAttribute>? {
        val user = AppContext.currentUser()

        val example = UserAttributeExample()
        var criteria = example.createCriteria().andUserIdEqualTo(user.id)
        if (dictId != null){
            criteria.andDictIdEqualTo(dictId)
        }
        return userAttributeMapper?.selectByExample(example)
    }
}
