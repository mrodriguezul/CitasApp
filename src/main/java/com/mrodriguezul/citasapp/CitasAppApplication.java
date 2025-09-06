package com.mrodriguezul.citasapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CitasAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitasAppApplication.class, args);
    }

}

// Note: This is a basic Spring Boot application starter class.
// It serves as the entry point for the Spring Boot application.
// The @SpringBootApplication annotation enables auto-configuration, component scanning, and configuration properties.
