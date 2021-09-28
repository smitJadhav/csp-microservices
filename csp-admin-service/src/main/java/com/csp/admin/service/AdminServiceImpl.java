package com.csp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

    //    @LoadBalanced
    //    private RestTemplate restTemplate;

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    //@HystrixCommand(fallbackMethod = "userServiceFallBack")
    @Override
    public String fetchAdminMessage(){
        String response = userServiceFeignClient.findMessage();
        //String response  = restTemplate.getForObject("http://user-service/user/message", String.class);
        return "Hi there, Welcome to admin functionality. " + response;
    }

    @Override
    public String fetchTestMessage(){
        return "Hi there, This is a test message.";
    }

    public String userServiceFallBack() {
        return "No Response From User Service at this moment. Service will be back shortly "+ new Date();
    }
}
