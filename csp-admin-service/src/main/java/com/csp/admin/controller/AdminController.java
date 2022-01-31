package com.csp.admin.controller;

import com.csp.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smit.Jadhav on 14-10-2020.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/message")
    public String fetchAdminMessage() throws Exception{
        return adminService.fetchAdminMessage();
    }

    @GetMapping("/test")
    public String fetchTestMessage(){
        return adminService.fetchTestMessage();
    }

    //Feign test
    @GetMapping("/feign-test")
    public String fetchFeignTestMessage() throws Exception{
        return adminService.fetchAdminMessage();
    }

}
