package com.pin2.proj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.pin2.proj.repositories.StorageService;
import com.pin2.proj.repositories.StorageProperties;

@SpringBootApplication

@EnableConfigurationProperties(StorageProperties.class)

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        
	}

	@Bean
    public WebMvcConfigurer configCORS() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }

    
}
