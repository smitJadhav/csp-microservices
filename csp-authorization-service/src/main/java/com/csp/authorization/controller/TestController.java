package com.csp.authorization.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping(value = "/message", produces = MediaType.TEXT_HTML_VALUE)
    public String fetchMessage() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n"
                + "<body>\n" + "<a href=\"http://localhost:8080/auth-jdbc-service/test/user\">USER</a>\n"
                + "<a href=\"http://localhost:8080/auth-jdbc-service/test/admin\">ADMIN</a>\n"
                + "<br>"
                + "<br>"
                + "<a href=\"http://localhost:8080/auth-jdbc-service/logout\">Logout</a>\n"
                + "</body>\n" + "</html>";
    }

    @GetMapping("/admin")
    @ResponseStatus
    public String fetchAdminMessage(){
        return "<p>HI Admin</p>";
    }

    @GetMapping("/user")
    @ResponseStatus
    public String fetchUserMessage(){
        return "<p>HI User</p>";
    }

}
