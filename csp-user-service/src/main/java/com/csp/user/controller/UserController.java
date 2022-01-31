package com.csp.user.controller;

import com.csp.model.GenericIdDTO;
import com.csp.user.domain.User;
import com.csp.user.model.UserDTO;
import com.csp.user.service.UserService;
import com.csp.util.exception.DataNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Smit.Jadhav on 14-10-2020.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/message")
    public String findMessage() throws Exception{
        if(true){
            throw new DataNotFound(User.class, "Message not found with id="+1);
        }
        return "Hi there, Message from User";
    }

    // This api creates user
    @PostMapping
    public GenericIdDTO saveUser(@RequestBody UserDTO userDTO) throws Exception{
        Long id = userService.saveUser(userDTO);
        return new GenericIdDTO(id);
    }

    @GetMapping("/{id}")
    public UserDTO fetchUSer(@PathVariable("id") Long id) throws Exception {
        return userService.findUser(id);
    }

}
