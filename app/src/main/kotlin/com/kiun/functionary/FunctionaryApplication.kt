package com.kiun.functionary

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
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
    runApplication<FunctionaryApplication>(*args)
}
