package com.kiun.functionary.service.imps

import com.google.gson.Gson
import com.kiun.functionary.base.BaseExampleMapper
import com.kiun.functionary.base.general.*
import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.BaseExample
import com.kiun.functionary.dao.GeneralListQuery
import com.kiun.functionary.dao.IdRandom
import com.kiun.functionary.service.GeneralService
import com.kiun.functionary.service.utils.StringUtil
import com.kiun.functionary.service.utils.mapOfLine
import com.kiun.functionary.service.utils.toJson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.context.annotation.ScannedGenericBeanDefinition
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.stereotype.Service
import java.lang.reflect.Type
import java.math.BigDecimal
import java.util.*

@Service("http")
class HttpGeneralService : GeneralService {

    var definition: Set<BeanDefinition>? = null
    init {
        val provider = ClassPathScanningCandidateComponentProvider(false)
        provider.addIncludeFilter(AnnotationTypeFilter(ListBuild::class.java))
        definition = provider.findCandidateComponents("com.kiun.functionary.dao.**")
    }

    @Autowired
    var gson: Gson? = null

    fun <T> getMapper(tableName: String): BaseExampleMapper<BaseExample, T>{
        return AppContext.getApplicationContext()
                .getBean("${StringUtil.firstToLower(tableName)}Mapper", BaseExampleMapper::class.java) as BaseExampleMapper<BaseExample, T>
    }

    private fun fileTypeConvert(type: Type): String{

        var formType = FormType.Auto
        if(type == String::class.java){
            formType = FormType.Text
        }else if (type == Int::class.java ||
                type == Long::class.java ||
                type == Double::class.java ||
                type == Float::class.java ||
                type == BigDecimal::class.java){
            formType = FormType.Number
        }else if (type == Date::class.java){
            formType = FormType.Date
        }
        return formType.toString()
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

    override fun getBuildByName(name: String): ListBuildData? {
        return definition
                ?.map { Gson().fromJson((it as ScannedGenericBeanDefinition).metadata.annotations.get(ListBuild::class.java).asMap().toJson(), ListBuildData::class.java) }
                ?.find { it.value == name }
    }

    override fun listBuildItem(name: String): List<ListBuildItemData>? {
        val def = definition?.find { name == (it as ScannedGenericBeanDefinition).metadata.annotations.get(ListBuild::class.java).asMap()["value"] }
        def?.let { dit ->
            val list = Class.forName(dit.beanClassName).declaredFields.mapNotNull {
                val anno = it?.getAnnotation(ListBuildItem::class.java)

                return@mapNotNull if (anno == null) null else ListBuildItemData(
                        value = if (anno.value == "") it.name else anno.value,
                        title = anno.title,
                        type = if (anno.type == FormType.Auto) fileTypeConvert(it.type) else anno.type.toString(),
                        tableWith = anno.tableWith,
                        enums = anno.enums.mapOfLine(),
                        addWith = anno.addWith,
                        editWith = anno.editWith
                )
            }
            return list
        }
        return null
    }

    override fun <T> getById(tableName: String, id: String): T {

        val mapper = getMapper<T>(tableName)
        val selectByPrimaryKey = mapper.javaClass.getMethod("selectByPrimaryKey", String::class.java)
        return selectByPrimaryKey.invoke(mapper, id) as T
    }
}
