package com.csp.admin;

import com.csp.config.Oauth2ResourceServerConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@ComponentScan(basePackages = "com.csp")
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "admin-service-ribbon", configuration = RibbonAutoConfiguration.class)
public class CspAdminServiceApplication extends Oauth2ResourceServerConfig {

	public static void main(String[] args) {
		SpringApplication.run(CspAdminServiceApplication.class, args);
	}

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/api-docs*", "/**/health").permitAll();
	}

}
