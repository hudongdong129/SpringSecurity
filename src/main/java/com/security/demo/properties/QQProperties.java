package com.security.demo.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security")
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    private String filterProcesserUrl = "/auth";

    private String signUpUrl = "/signup.html";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getFilterProcesserUrl() {
        return filterProcesserUrl;
    }

    public void setFilterProcesserUrl(String filterProcesserUrl) {
        this.filterProcesserUrl = filterProcesserUrl;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
