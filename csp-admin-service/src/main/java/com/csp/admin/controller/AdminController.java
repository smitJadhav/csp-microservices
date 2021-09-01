package com.csp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.csp.admin.service.UserServiceFeignClient;


/**
 * @author Smit.Jadhav on 14-10-2020.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

//    @LoadBalanced
//    private RestTemplate restTemplate;

	@Autowired
	private UserServiceFeignClient userServiceFeignClient;

	@GetMapping("/message")
	public String fetchAdminMessage(){
		String response = userServiceFeignClient.findMessage();
		//String response  = restTemplate.getForObject("http://user-service/user/message", String.class);
		return "Hi there, Welcome to admin functionality. " + response;
	}

}
