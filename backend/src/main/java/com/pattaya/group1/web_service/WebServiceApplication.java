package com.pattaya.group1.web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }


    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/logs").allowedOrigins("http://localhost:4200");
			}
		};
	}

}
