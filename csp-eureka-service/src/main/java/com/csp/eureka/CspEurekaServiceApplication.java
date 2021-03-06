package com.csp.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CspEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CspEurekaServiceApplication.class, args);
    }

}
