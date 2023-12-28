package com.kiun.functionary.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "file")
class FileProperties {

    var path: String? = null
}
