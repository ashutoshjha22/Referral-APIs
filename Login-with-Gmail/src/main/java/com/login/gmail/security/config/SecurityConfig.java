package com.login.gmail.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.login.gmail.oAuth2.success.handler.CustomOAuth2SuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .antMatchers("/", "/login", "/oauth2/**").permitAll()
                    .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .successHandler(oAuth2SuccessHandler())
            );
        return http.build();
    }

    @Bean
    public CustomOAuth2SuccessHandler oAuth2SuccessHandler() {
        return new CustomOAuth2SuccessHandler();
    }
}
