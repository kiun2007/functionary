package com.kiun.functionary.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "http")
class HttpPortProperties {

    var port: Int = 80
}
