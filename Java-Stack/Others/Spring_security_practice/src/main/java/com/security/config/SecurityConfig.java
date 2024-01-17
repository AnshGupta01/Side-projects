package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails normalUser= User
                .withUsername("ansh")
                .password(passwordEncoder().encode("ansh"))
                .roles("NORMAL")
                .build();

        UserDetails adminUser= User
                .withUsername("ansh2")
                .password(passwordEncoder().encode("ansh2"))
                .roles("ADMIN")
                .build();

        //implementation class of UserDetailsService
        return new InMemoryUserDetailsManager(normalUser, adminUser);
//        return new CustomUserDetailService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/home/admin/**")
//                        .hasRole("ADMIN")
//                        .requestMatchers("/home/normal/**")
//                        .hasRole("NORMAL")
                        .requestMatchers("/home/public/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin();
        return httpSecurity.build();
    }
}