package com.kiun.functionary.config

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.apache.ibatis.session.SqlSessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.GsonFactoryBean

@Configuration
open class DataConfig {

    @Bean
    open fun gson(): Gson {
        return GsonFactoryBean().`object`?: GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
    }
}
