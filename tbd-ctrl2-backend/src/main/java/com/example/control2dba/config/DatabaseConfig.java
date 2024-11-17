package com.example.control2dba.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseConfig {
    @Bean
    public Sql2o sql2o() {
        return new Sql2o("jdbc:postgresql://localhost:5432/dba-control2", "postgres", "123");
    }
}

