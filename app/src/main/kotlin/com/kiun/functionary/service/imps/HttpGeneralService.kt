package com.kiun.functionary.service.imps

import com.google.gson.Gson
import com.kiun.functionary.base.BaseExampleMapper
import com.kiun.functionary.base.anno.StartPage
import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.BaseExample
import com.kiun.functionary.dao.GeneralListQuery
import com.kiun.functionary.dao.IdRandom
import com.kiun.functionary.dao.sys.SysDictMapper
import com.kiun.functionary.service.GeneralService
import com.kiun.functionary.service.utils.StringUtil
import com.kiun.functionary.service.utils.toJson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder

@Service("http")
class HttpGeneralService : GeneralService {

    @Autowired
    var gson: Gson? = null

    fun <T> getMapper(tableName: String): BaseExampleMapper<BaseExample, T>{
        return AppContext.getApplicationContext()
                .getBean("${StringUtil.firstToLower(tableName)}Mapper", BaseExampleMapper::class.java) as BaseExampleMapper<BaseExample, T>
    }

    override fun <T> selectList(tableName: String, request: Map<String, Any>): List<T>? {

        val mapper = getMapper<T>(tableName)

        val example = BaseExample.getExample(tableName)
        val type = example.entryClass
        val queryType = AppContext.getRequest().getHeader("QueryType") ?: GeneralListQuery.QueryType.Eq.toString()

        if (type != null){
            example.fillEntity<BaseExample>(gson?.fromJson(request.toJson(), type), queryType)
        }else{
            example.fill<BaseExample>(request, queryType)
        }
        return mapper.selectByExample(example)
    }

    override fun insertOrUpdateSelective(tableName: String, body: String): Boolean {

        val mapper = getMapper<Any>(tableName)

        val example = BaseExample.getExample(tableName)
        val entry = gson?.fromJson(body, example.entryClass)

        if (entry is IdRandom && !entry.isNew){
            return mapper.updateByPrimaryKeySelective(entry) > 0
        }
        return mapper.insertOne(entry) > 0
    }

    override fun insert(tableName: String, body: String): Boolean {

        val mapper = getMapper<Any>(tableName)
        val example = BaseExample.getExample(tableName)
        val entry = gson?.fromJson(body, example.entryClass)
        return mapper.insertOne(entry) > 0
    }
}
