package com.example.control2dba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilita CSRF por ser una API
                .cors((cors) -> {}) // Habilita CORS
                .authorizeHttpRequests(authorize -> authorize // Configura las rutas que requieren autenticación
                        .requestMatchers("/establecimientos/").hasAnyRole("MOD") // Solo los ADMIN pueden acceder a /establecimientos/**
                        .requestMatchers("/establecimientos/**").hasAnyRole("ADMIN") // Solo los ADMIN pueden acceder a /establecimientos/**
                        .requestMatchers("/auth/**").permitAll() // Todos pueden acceder a /auth/**
                        .requestMatchers("/api/usuario/**").permitAll() // Todos pueden acceder a /auth/**
                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
                .sessionManagement(session -> session // Configura la política de creación de sesiones
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No se crean sesiones
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Agrega el filtro de JWT antes del filtro de autenticación
        return http.build();
    }
}