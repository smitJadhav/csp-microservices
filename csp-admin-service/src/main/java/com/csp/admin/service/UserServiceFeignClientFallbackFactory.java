package com.csp.admin.service;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class UserServiceFeignClientFallbackFactory //implements FallbackFactory<UserServiceFeignClient> {
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceFeignClientFallbackFactory.class);

//    @Override
//    public String findMessage() {
//        return "No Response From User Service at this moment. Service will be back shortly "+ new Date();
//    }

/*    @Override
    public UserServiceFeignClient create(Throwable cause) {
        return new UserServiceFeignClient() {
            @Override
            public String findMessage() {
                UserServiceFeignClientFallbackFactory.LOGGER.info("No Response From User Service at this moment. Service will be back shortly: {}, {}", cause.getMessage(), cause);
                return new String("No Response From User Service at this moment. Service will be back shortly" + cause.getMessage());
            }
        };
    }*/
}
