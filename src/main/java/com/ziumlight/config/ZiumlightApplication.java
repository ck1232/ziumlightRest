package com.ziumlight.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ziumlight"}, excludeFilters = {
		@Filter(type = FilterType.REGEX, pattern="com.ziumlight.dao.*"),
		@Filter(type = FilterType.REGEX, pattern="com.ziumlight.to.*"),
})
@EnableAutoConfiguration(exclude = {/*SecurityAutoConfiguration.class, ErrorMvcAutoConfiguration.class*/})
@EntityScan("com.ziumlight.to")
@EnableJpaRepositories("com.ziumlight.dao")
public class ZiumlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZiumlightApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
