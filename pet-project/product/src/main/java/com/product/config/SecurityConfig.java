package com.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers("storefront/**").permitAll()
                                .requestMatchers("backoffice").hasRole("ADMIN").anyRequest().authenticated()
                    )
                    .oauth2ResourceServer(auth -> auth.jwt(Customizer.withDefaults())).build();

    }
}
