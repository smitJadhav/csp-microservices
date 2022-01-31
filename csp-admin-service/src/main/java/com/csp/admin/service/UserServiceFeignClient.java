package com.csp.admin.service;

import com.csp.admin.config.CustomFeignClientExceptionConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * @author Smit.Jadhav on 15-07-2021.
 */

@FeignClient(name="user-service", configuration = CustomFeignClientExceptionConfig.class)
public interface UserServiceFeignClient {

    final static String USER_SERVICE_CB = "userServiceCB";

    @GetMapping("/user/message")
    @CircuitBreaker(name = USER_SERVICE_CB, fallbackMethod = "userServiceFallBack")
    public String findMessage();

    default String userServiceFallBack(Throwable throwable) {
        return "No Response From User Service at this moment. Service will be back shortly "+ new Date() + ", Throwable class : " + throwable.getClass() +", Stack trace : "+ ExceptionUtils.getFullStackTrace(throwable);
    }
}
