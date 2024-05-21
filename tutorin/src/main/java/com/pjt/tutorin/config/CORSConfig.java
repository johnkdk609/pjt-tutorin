package com.pjt.tutorin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 1. 설정 파일(클래스)을 스프링이 인식하려면 @Configuration을 꼭 붙여줘야 한다.
// 2. 만약 설정 중에서도 Spring Web 또는 MVC와 관련된 설정이라면 implements WebMvcConfigurer
// 3. WebMvcConfigurer 인터페이스에 정의된 함수 중 하나를 오버라이드 해서 설정을 작성한다.

@Configuration
public class CORSConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.allowedOrigins("http://localhost:5173")
			.allowCredentials(true)
			.exposedHeaders("*")
			.maxAge(3600);	// Preflight Caching
	}
}
