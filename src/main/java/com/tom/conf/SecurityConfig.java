package com.tom.conf;

import com.tom.service.impl.SpringSecUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/*
    Spring Security 设置类
    @EnableWebSecurity 开启全局权限管理
    @EnableGlobalMethodSecurity(securedEnabled = true) 启用 @Secured 注解
*/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService springSecUserServiceImpl() {
        return new SpringSecUserServiceImpl();  // 引入用户自定义的 UserDetailsService
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/assets/**").permitAll()
            .antMatchers("/error/**").permitAll()
            .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login")
                .permitAll()
            .and()
                .logout()
                .permitAll();
    }
}
