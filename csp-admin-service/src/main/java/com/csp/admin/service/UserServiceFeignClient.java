package com.csp.admin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Smit.Jadhav on 15-07-2021.
 */

@FeignClient(name="user-service")
public interface UserServiceFeignClient {

    @GetMapping("/user/message")
    public String findMessage();
}
