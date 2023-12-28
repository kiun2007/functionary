package com.kiun.functionary.config

import com.kiun.functionary.context.AppContext
import com.kiun.functionary.fegin.wx.WxOpenService
import com.kiun.functionary.service.wx.WxCoreTokenService
import org.apache.http.client.utils.URIBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class WxWebConfig {

    @Bean
    fun webClient(): WebClient{

        return WebClient.builder().baseUrl("https://api.weixin.qq.com/").filter { request, next ->

            val urlBuilder = URIBuilder(request.url().toString())
            val wxCoreTokenService = AppContext.getBean(WxCoreTokenService::class.java)

            if (wxCoreTokenService.miniAppToken != null && !request.url().toString().contains("sns/jscode2session")){
                urlBuilder.addParameter("access_token", wxCoreTokenService.miniAppToken)
            }

            urlBuilder.addParameter("appid", "wxcf631fb8350c0b6b")
            urlBuilder.addParameter("secret", "020f959a4073d1a8389635f8dd7cbee1")

            val filtered = ClientRequest.from(request)
                .url(urlBuilder.build()).header("Content-type", "application/json;charset=utf-8")
                .build()
            next.exchange(filtered)
        }.build()
    }

    @Bean
    fun officialWebClient(): WebClient{

        return WebClient.builder().baseUrl("https://api.weixin.qq.com/").filter { request, next ->

            val urlBuilder = URIBuilder(request.url().toString())
            val wxCoreTokenService = AppContext.getBean(WxCoreTokenService::class.java)

            if (wxCoreTokenService.officialToken != null && !request.url().toString().contains("sns/jscode2session")){
                urlBuilder.addParameter("access_token", wxCoreTokenService.officialToken)
            }

            urlBuilder.addParameter("appid", "wx73a2b715dff55bc1")
            urlBuilder.addParameter("secret", "70050711253c2dd462afe616999508e2")

            val filtered = ClientRequest.from(request)
                .url(urlBuilder.build()).header("Content-type", "application/json;charset=utf-8")
                .build()
            next.exchange(filtered)
        }.build()
    }

    @Bean
    fun proxyFactory(): HttpServiceProxyFactory {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient())).build()
    }

    @Bean
    fun officialProxyFactory(): HttpServiceProxyFactory {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(officialWebClient())).build()
    }

    @Bean
    fun wxOpenService(): WxOpenService {
        return proxyFactory().createClient(WxOpenService::class.java)
    }

    @Bean
    fun officialService(): WxOpenService {
        return officialProxyFactory().createClient(WxOpenService::class.java)
    }
}
