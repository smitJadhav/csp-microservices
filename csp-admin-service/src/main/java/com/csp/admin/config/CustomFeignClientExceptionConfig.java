package com.csp.admin.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomFeignClientExceptionConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
