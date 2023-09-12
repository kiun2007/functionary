package com.kiun.functionary.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ThreadLocalConfig {

    @Bean
    fun threadLocal(): ThreadLocal<Any>{
        return ThreadLocal<Any>()
    }

}
