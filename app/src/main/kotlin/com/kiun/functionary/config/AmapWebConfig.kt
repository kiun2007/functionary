package com.kiun.functionary.config

import com.kiun.functionary.fegin.wx.AmapOpenService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class AmapWebConfig {

    @Bean
    fun v3client(): WebClient {
        return WebClient.builder().baseUrl("https://restapi.amap.com/v3/").build()
    }

    @Bean
    fun v3proxyFactory(): HttpServiceProxyFactory {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(v3client())).build()
    }

    @Bean
    fun amapOpenService(): AmapOpenService {
        return v3proxyFactory().createClient(AmapOpenService::class.java)
    }
}
