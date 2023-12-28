package com.kiun.functionary.config

import com.aliyuncs.exceptions.ClientException
import com.kiun.functionary.base.DataWrap
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.reflect.UndeclaredThrowableException

@RestControllerAdvice
class GlobalBizExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGlobalException(e: Exception): DataWrap<*> {

        // 业务异常交由 sentinel 记录
        e.printStackTrace()
        if (e is UndeclaredThrowableException) {
            val throwable = e.undeclaredThrowable
            return DataWrap.fail<Any>(throwable.message)
        }

        if (e is DuplicateKeyException){
            return DataWrap.fail<Any>("不允许重复")
        }

        return if (e is ClientException) {
            DataWrap.fail<Any>("注册中心找不到服务")
        } else DataWrap.fail<Any>(e.localizedMessage)
    }
}
