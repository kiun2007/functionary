package com.kiun.functionary.config

import com.google.gson.Gson
import org.apache.ibatis.session.SqlSessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.GsonFactoryBean

@Configuration
class DataConfig {

    @Bean
    fun gson(): Gson {
        return GsonFactoryBean().`object`?: Gson()
    }
}
