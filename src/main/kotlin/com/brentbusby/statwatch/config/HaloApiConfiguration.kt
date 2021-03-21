package com.brentbusby.statwatch.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties
class HaloApiConfiguration {
    @Value("\${statwatch.halo.subscriptionKey}")
    lateinit var subscriptionKey: String
}