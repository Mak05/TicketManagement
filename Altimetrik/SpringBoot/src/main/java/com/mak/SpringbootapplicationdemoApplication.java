package com.mak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.mak.controller", "com.mak.service, com.mak.model" })
@EnableJpaRepositories(basePackages = { "com.mak.dao" })
public class SpringbootapplicationdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootapplicationdemoApplication.class, args);
	}

}
