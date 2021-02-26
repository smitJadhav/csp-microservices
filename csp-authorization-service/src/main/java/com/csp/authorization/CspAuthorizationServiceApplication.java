package com.csp.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@ComponentScan(basePackages = "com.csp")
@EnableJpaRepositories(basePackages = "com.csp")
@EnableJpaAuditing
//@EnableResourceServer  // just for testing resource server
public class CspAuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CspAuthorizationServiceApplication.class, args);
	}

}
