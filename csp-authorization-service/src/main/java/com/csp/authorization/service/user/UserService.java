package com.csp.authorization.service.user;

import com.csp.authorization.model.UserDetailsDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public void loginFailed(UserDetailsDTO userDetailsDTO);
    public void loginSucceeded(Long userName);
}
