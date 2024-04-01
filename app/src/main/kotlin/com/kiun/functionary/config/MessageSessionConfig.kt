package com.kiun.functionary.config

import com.kiun.functionary.base.MessageSession
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessageSessionConfig {

    @Bean
    fun messageSession() : MessageSession {
        return MessageSession(true)
    }
}
