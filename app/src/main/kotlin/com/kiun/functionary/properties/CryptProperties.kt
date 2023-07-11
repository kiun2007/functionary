package com.kiun.functionary.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "security.crypt")
class CryptProperties {

    /**
     * 加密盐
     */
    var salt: String? = null
}
