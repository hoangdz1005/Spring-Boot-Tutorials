package com.hoangdz.securitysection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // config custom request
        http
                .authorizeHttpRequests((request) ->
                        request.requestMatchers("/myAccount", "/myBalance","/myCards","/myLoans").authenticated()
                                .requestMatchers("/contact","/notices").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();

        /* config deny all requests
        http
                .authorizeHttpRequests((request) ->
                    request.requestMatchers("/myAccount", "/myBalance","/myCards","/myLoans","/contact","/notices").authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());*/

        /*config permit all requests
        http
                .authorizeHttpRequests((request) ->
                        request.requestMatchers("/myAccount", "/myCards", "/myLoans","/contact","/notices").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());*/

    }
}
