package com.kiun.functionary.config

import com.wechat.pay.java.service.payments.jsapi.JsapiService
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WxJsapiConfig {

    @Value("wxpay.mchid")
    private var mchId: String? = null

    @Value("wxpay.apiv3key")
    private var apiv3key: String? = null

    @Value("wxpay.certpath")
    private var certpath: String? = null

    @Bean
    fun jsapiService(): JsapiService {
        val config = RSAAutoCertificateConfig
            .Builder()
            .merchantId(mchId) //商户号
            .apiV3Key(apiv3key) //商户证书序列号
            .privateKeyFromPath(certpath) //商户证书私钥
            .build()
        return JsapiService.Builder().config(config).build()
    }

}
