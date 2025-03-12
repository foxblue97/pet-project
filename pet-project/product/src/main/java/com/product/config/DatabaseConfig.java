package com.product.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@Configuration
@EntityScan("com.product.model")
@EnableJpaRepositories("com.product.repository")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class DatabaseConfig {

    @Bean
   public AuditorAware<String> auditorAware (){
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null){
                return Optional.of(" ");
            }
            return Optional.of(authentication.getName());
        };
    }
}
