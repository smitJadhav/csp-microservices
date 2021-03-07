package com.csp.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smit.Jadhav on 14-10-2020.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/message")
    public String fetchAdminMessage(){
        return "Hi there, Welcome to admin functionality";
    }

}
