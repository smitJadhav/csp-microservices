package com.csp.admin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "csp-user-service")
public interface UserServiceFeignClient {

    @GetMapping("/user/message")
    public String findMessage();
}
