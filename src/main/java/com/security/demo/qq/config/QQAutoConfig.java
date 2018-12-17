package com.security.demo.qq.config;

import com.security.demo.properties.QQProperties;
import com.security.demo.properties.SecurityProperties2;
import com.security.demo.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
//@ConditionalOnProperty()
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

//    @Autowired
//    private SecurityProperties2 securityProperties;

    @Autowired
    private QQProperties qqProperties;



    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
//        QQProperties qqProperties = securityProperties.getSocial().getQq();

        return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }
}
