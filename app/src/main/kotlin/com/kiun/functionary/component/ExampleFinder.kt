package com.kiun.functionary.component

import com.kiun.functionary.dao.BaseExample
import com.kiun.functionary.service.utils.AnnotationUtil
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class ExampleFinder {

    val exampleMap: MutableMap<String, Class<out BaseExample>> = HashMap()

    init {
        val list = AnnotationUtil.getChildClass(BaseExample::class.java, null)
        list.remove(BaseExample::class.java)

        list.forEach{
            exampleMap[it.simpleName] = it as Class<out BaseExample>
        }
    }

    /**
     * 查找并创建
     */
    fun findAndCreate(name: String) : BaseExample?{
        val clz = exampleMap.filter { it.key == name || it.key.toLowerCase() == "${name.toLowerCase()}example" }.values.firstOrNull()
        if (clz != null){
            return clz.getDeclaredConstructor().newInstance()
        }
        throw RuntimeException("未查询到对应数据集")
    }

    companion object {

    }
}
