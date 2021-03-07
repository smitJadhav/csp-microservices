package com.csp.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.csp")
@EnableJpaRepositories(basePackages = "com.csp")
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class CspAuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CspAuthorizationServiceApplication.class, args);
	}

}
