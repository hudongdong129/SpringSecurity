package com.security.demo.config;

import com.security.demo.properties.QQProperties;
import com.security.demo.properties.SecurityProperties2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @ConfigurationProperties(prefix="hu.security")
    @Bean
    public QQProperties securityProperties() {
        return new QQProperties();
    }


}
