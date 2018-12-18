package com.security.demo.qq;

import com.security.demo.properties.QQProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;


@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private QQProperties qqProperties;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
         JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
         jdbcUsersConnectionRepository.setTablePrefix("hu_");
        return jdbcUsersConnectionRepository;

    }


    @Bean
    public SpringSocialConfigurer springSocialConfigurer() {
        String filterProcesserUrl = qqProperties.getFilterProcesserUrl();
        HuSpringSocialConfigurer configurer = new HuSpringSocialConfigurer(filterProcesserUrl);
        configurer.signupUrl(qqProperties.getSignUpUrl());
        return configurer;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator)){};
    }
}
