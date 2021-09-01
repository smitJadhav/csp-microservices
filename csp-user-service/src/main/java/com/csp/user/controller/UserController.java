package com.csp.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smit.Jadhav on 14-10-2020.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/message")
    public String findMessage(){
        return "Hi there, Message from User";
    }

}
