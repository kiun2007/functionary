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
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.context.annotation.ScannedGenericBeanDefinition
import org.springframework.core.ParameterizedTypeReference
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
        try {
            return AppContext.getApplicationContext()
                    .getBean("${StringUtil.firstToLower(tableName)}Mapper", BaseExampleMapper::class.java) as BaseExampleMapper<BaseExample, T>
        }catch (ex: Exception){
        }
        return AppContext.getApplicationContext()
                .getBean("${tableName}Mapper", BaseExampleMapper::class.java) as BaseExampleMapper<BaseExample, T>
    }

    private fun fileTypeConvert(type: Type): String{

        var formType = FormType.Auto
        if(type == String::class.java){
            formType = FormType.Text
        }else if (type == Int::class.java ||
                type == Integer::class.java ||
                type == Long::class.java ||
                type == java.lang.Long::class.java ||
                type == Double::class.java ||
                type == java.lang.Double::class.java ||
                type == Float::class.java ||
                type == java.lang.Float::class.java ||
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
            val query = gson?.fromJson(request.toJson(), type)
            if (query is IdRandom && query.isNew){
                query.setId(null);
            }
            example.fillEntity<BaseExample>(query, queryType)
        }else{
            example.fill<BaseExample>(request, queryType)
        }
        return mapper.selectByExample(example)
    }

    fun fillEntryUser(entry: Any?){

        if (entry == null){
            return
        }

        entry.javaClass.getDeclaredFields().forEach {
            val userId: UserId? = it.getAnnotation(UserId::class.java)
            it.setAccessible(true)
            var value: Any? = it.get(entry)
            if (value == null && userId != null) {
                val user = AppContext.currentUser()
                value = user?.id!!
            }
            it.set(entry, value)
        }

    }

    override fun insertOrUpdateSelective(tableName: String, body: String): Boolean {

        val mapper = getMapper<Any>(tableName)

        val example = BaseExample.getExample(tableName)
        val entry = gson?.fromJson(body, example.entryClass)
        fillEntryUser(entry)

        if (entry is IdRandom && !entry.isNew){
            return mapper.updateByPrimaryKeySelective(entry) > 0
        }
        return mapper.insertOne(entry) > 0
    }

    override fun insert(tableName: String, body: String): Boolean {

        val mapper = getMapper<Any>(tableName)
        val example = BaseExample.getExample(tableName)
        val entry = gson?.fromJson(body, example.entryClass)
        fillEntryUser(entry)

        if (entry is IdRandom){
            entry.fillId()
        }
        return mapper.insertOne(entry) > 0
    }

    override fun update(tableName: String, body: String): Boolean {
        val mapper = getMapper<Any>(tableName)
        val example = BaseExample.getExample(tableName)
        val entry = gson?.fromJson(body, example.entryClass)
        fillEntryUser(entry)

        val methods = mapper.javaClass.interfaces.map { iit-> iit.methods.find { it.name == "selectByPrimaryKey" } }.first()

        val query = gson?.fromJson(body, object : ParameterizedTypeReference<Map<String, Any>>(){}.type) as Map<String, Any>
        val newMap = HashMap<String, Any>()
        query.filter { it.key.endsWith("__old") }.forEach{
            key, value->
            val oldKey = key.replace("__old", "")
            if (methods?.parameters?.any { it.name == oldKey } == true){
                newMap[oldKey] = value
            }
        }

        val queryType = AppContext.getRequest().getHeader("QueryType") ?: GeneralListQuery.QueryType.Eq.toString()
        example.fill<BaseExample>(newMap, queryType)
        return mapper.updateByExampleSelective(entry, example) > 0
    }

    override fun getBuildByName(name: String): ListBuildData? {
        return definition
                ?.map {
                    val listBuild = Class.forName((it as ScannedGenericBeanDefinition).metadata.className).getAnnotation(ListBuild::class.java)
                    return@map ListBuildData(
                            value = listBuild.value,
                            title = listBuild.title,
                            operate = listBuild.operate.map {
                                OperateData(
                                        title = it.title,
                                        url = it.url.replace("@{formId}", name),
                                        icon = it.icon,
                                        function = it.function,
                                        color = it.color,
                                        toolbar = it.toolbar
                                )
                            }.toTypedArray()
                    )
                }
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
                        enums = anno.enums.mapOfLine(),
                        flag = anno.flag,
                        selectOpt = SelectData(
                                label = anno.selectOpt.label,
                                formLabel = anno.selectOpt.formLabel,
                                formValue = anno.selectOpt.formValue,
                                url = anno.selectOpt.url,
                        )
                )
            }
            return list
        }
        return null
    }

    /**
     * 根据条件删除
     */
    override fun delete(tableName: String, query: Map<String, Any>): Boolean {

        val mapper = getMapper<Any>(tableName)
        val example = BaseExample.getExample(tableName)
        val type = example.entryClass
        val queryType = AppContext.getRequest().getHeader("QueryType") ?: GeneralListQuery.QueryType.Eq.toString()

        if (type != null){
            val query = gson?.fromJson(query.toJson(), type)
            if (query is IdRandom && query.isNew){
                query.setId(null);
            }
            example.fillEntity<BaseExample>(query, queryType)
            return mapper.deleteByExample(example) > 0
        }
        return false
    }

    override fun <T> getById(tableName: String, query: MutableMap<String, Any>): T {

        val mapper = getMapper<T>(tableName)
        val selectByPrimaryKey = mapper.javaClass.interfaces.map { iit-> iit.methods.find { it.name == "selectByPrimaryKey" } }.first()

        if(selectByPrimaryKey?.parameters?.size == 1){
            return selectByPrimaryKey?.invoke(mapper, query.values.first()) as T
        }

        val param = selectByPrimaryKey?.parameters?.map { query[it.getAnnotation(Param::class.java).value] as Any }?.toTypedArray()
        return selectByPrimaryKey?.invoke(mapper, *param!!) as T
    }
}
