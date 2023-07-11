package com.kiun.functionary.aop

import com.github.pagehelper.PageHelper
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class StartPageAop {

    @Before("@annotation(com.kiun.functionary.base.anno.StartPage)")
    fun beforeStartPageAnno(){
        var request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?)!!.request
        val pageNum = request.getHeader("pageNum")
        val pageSize = request.getHeader("pageSize")

        if (pageNum != null && pageSize != null){
            PageHelper.startPage<Any>(pageNum.toInt(), pageSize.toInt())
        }
    }
}
