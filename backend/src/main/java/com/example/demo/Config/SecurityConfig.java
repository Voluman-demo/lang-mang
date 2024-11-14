package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Włącz CORS
                .and()
                .csrf(csrf -> csrf.disable()) // Wyłącz CSRF na potrzeby testów
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/**").permitAll() // Zezwól na dostęp do endpointów API bez autoryzacji
                        .anyRequest().permitAll() // Zezwól na dostęp do innych endpointów
                );

        return http.build();
    }
}
