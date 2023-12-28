package com.kiun.functionary.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "debug")
class DebugProperties {

    var noSmsSend: Boolean? = false
}
