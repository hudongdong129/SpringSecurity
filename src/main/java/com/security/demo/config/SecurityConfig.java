package com.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表示使用form表单提交
            .loginPage("/login.html")//我们定义的登录页
            .loginProcessingUrl("/authentication/form")//因为SpringSecurity默认是login请求为登录请求，所以需要配置自己的请求路径
            .and()
            .authorizeRequests()//对请求进行授权
            .antMatchers("/login.html").permitAll()//表示login.html路径不会被拦截
            .anyRequest()//表示所有请求
            .authenticated()//需要权限认证
            .and()
            .csrf().disable();//这是SpringSecurity的安全控制，我们这里先关掉
    }
}
