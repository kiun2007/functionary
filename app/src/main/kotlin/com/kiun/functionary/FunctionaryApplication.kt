package com.kiun.functionary

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
@MapperScan("com.kiun.functionary.dao.**")
@ComponentScan("com.kiun.functionary.**", "com.github.pagehelper.**")
class FunctionaryApplication

fun main(args: Array<String>) {

    val sb = StringBuffer("[")
    for (i in 1 until 5000){
        if (i == 1){
            sb.append("${i}")
        }else{
            sb.append(",${i}")
        }
    }
    sb.append("]")
    var s = sb.toString()
    runApplication<FunctionaryApplication>(*args)
}
