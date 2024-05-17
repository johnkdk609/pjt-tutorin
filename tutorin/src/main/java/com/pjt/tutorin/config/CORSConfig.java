package com.pjt.tutorin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CORSConfig {

	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.allowedOrigins("http://127.0.0.1:5173")
			.allowCredentials(true)
			.exposedHeaders("*")
			.maxAge(3600);	// Preflight Caching
	}
}
