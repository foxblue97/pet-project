package com.product.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "house.service")
public record ServiceConfig(
        String product,
        String media
) {

}
