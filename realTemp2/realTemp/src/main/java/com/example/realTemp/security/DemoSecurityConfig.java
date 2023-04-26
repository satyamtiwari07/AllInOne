package com.example.realTemp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class DemoSecurityConfig{

    @Bean
    public  UserDetailsService userDetailsService() {

        List<UserDetails> users = new ArrayList<>();
        users.add(User.withUsername("Satyam").password("{noop}root").roles("ADMIN").build());
        users.add(User.withUsername("jadon").password("{noop}pass").roles("USER").build());
        users.add(User.withUsername("solace").password("{noop}pass").roles("USER").build());

        return new InMemoryUserDetailsManager(users);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer.requestMatchers(HttpMethod.GET,"/api/drivers")
                        .hasRole("USER")

                        .requestMatchers(HttpMethod.POST,"/api")
                        .hasRole("USER")

                        .requestMatchers(HttpMethod.POST,"/add")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/vehicals")
                        .hasRole("USER")
                        .anyRequest()
                        .authenticated()
        );

        http.httpBasic();
        http.csrf().disable();
        return http.build();
    }

}
