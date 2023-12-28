package com.kiun.functionary.config

import com.kiun.functionary.properties.HttpPortProperties
import org.apache.catalina.connector.Connector
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class HttpsConfig {

    @Autowired
    private val httpPort: HttpPortProperties? = null

    @Bean
    fun servletContainer() : TomcatServletWebServerFactory {
        val tomcat = TomcatServletWebServerFactory()
        tomcat.addAdditionalTomcatConnectors(httpConnector())
        return tomcat
    }

    @Bean
    fun httpConnector() : Connector
    {
        val connector = Connector("org.apache.coyote.http11.Http11NioProtocol")
        connector.port = httpPort?.port?:80
        return connector
    }
}
