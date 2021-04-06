package com.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.dao")
@EntityScan(basePackages = "com.dto")
@SpringBootApplication(scanBasePackages = "com")
public class FinalProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FinalProjectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}
