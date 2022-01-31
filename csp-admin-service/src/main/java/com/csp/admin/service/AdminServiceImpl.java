package com.csp.admin.service;

import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @Override
    public String fetchAdminMessage() throws Exception{
        try {
            String response = userServiceFeignClient.findMessage();
            return "Hi there, Welcome to admin functionality. " + response;
        } catch (FeignException ex){
            LOGGER.error("localized : " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public String fetchTestMessage(){
        return "Hi there, This is a test message.";
    }

}
