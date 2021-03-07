package com.csp.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/message")
    public String fetchAdminMessage(){
        return "Hi there, Welcome to csp auth app";
    }

}
