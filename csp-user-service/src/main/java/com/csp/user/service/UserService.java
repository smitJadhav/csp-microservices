package com.csp.user.service;

import com.csp.user.model.UserDTO;

public interface UserService {

    Long saveUser(UserDTO userDTO);
    UserDTO findUser(Long id) throws Exception;
}
