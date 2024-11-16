package com.example.control2dba.config;

import com.example.control2dba.entities.UsuarioEntity;
import com.example.control2dba.repositories.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private UsuarioRepository usuarioRepository;

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
                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
                .sessionManagement(session -> session // Configura la política de creación de sesiones
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No se crean sesiones
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Agrega el filtro de JWT antes del filtro de autenticación
        return http.build();
    }

    // Configuración para que Spring Security use el repositorio de usuarios, de que forma se encriptan las contraseñas y el servicio de autenticación
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UsuarioEntity user = usuarioRepository.getUsuarioId(username);
            if (user == null) {
                throw new org.springframework.security.core.userdetails.UsernameNotFoundException(username);
            }
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getContrasena())
                    .build();
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } // Configura el encriptador de contraseñas
}