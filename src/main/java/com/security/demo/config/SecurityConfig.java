package com.security.demo.config;

import com.security.demo.authentication.DemoAuthenticationFailureHandler;
import com.security.demo.authentication.DemoAuthenticationSuccessHandler;
import com.security.demo.filter.SmsCodeFilter;
import com.security.demo.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DemoAuthenticationSuccessHandler demoAuthenticationSuccessHandler;

    @Autowired
    private DemoAuthenticationFailureHandler demoAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private CodeProperties codeProperties;
//
//    @Autowired
//    private UserDetailsService userDetailsService;

    @Autowired
    private SpringSocialConfigurer springSocialConfigurer;


    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setDemoAuthenticationFailureHandler(demoAuthenticationFailureHandler);

        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setDemoAuthenticationFailureHandler(demoAuthenticationFailureHandler);

        http.addFilterBefore(smsCodeFilter,UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)//在UsernamePasswordAuthenticationFilter添加新添加的拦截器
             .formLogin()//表示使用form表单提交
            .loginPage("/login.html")//我们定义的登录页
            .loginProcessingUrl("/authentication/form")//因为SpringSecurity默认是login请求为登录请求，所以需要配置自己的请求路径
            .successHandler(demoAuthenticationSuccessHandler)//登录成功的操作
            .failureHandler(demoAuthenticationFailureHandler)//登录失败的操作
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())

            .and()
            .authorizeRequests()//对请求进行授权
            .antMatchers("/login.html","/code/*","/user/regist","/signup.html","/social/user").permitAll()//表示login.html路径不会被拦截
            .anyRequest()//表示所有请求
            .authenticated()//需要权限认证
            .and()
            .csrf().disable()
                .apply(springSocialConfigurer)
                .and()
            .apply(smsCodeAuthenticationSecurityConfig);//这是SpringSecurity的安全控制，我们这里先关掉

    }
}
