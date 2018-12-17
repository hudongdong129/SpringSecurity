package com.security.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix="hu.security")
public class SecurityProperties2 {

    private SocialProperties2 social= new SocialProperties2();

    public SocialProperties2 getSocial() {
        return social;
    }

    public void setSocial(SocialProperties2 social) {
        this.social = social;
    }
}
