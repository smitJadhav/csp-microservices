package com.csp.authorization.config;

import com.csp.authorization.model.UserDetailsDTO;
import com.csp.authorization.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        UserDetailsDTO userDetailsDTO = (UserDetailsDTO)userDetails;

        if (usernamePasswordAuthenticationToken.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may not be null.");
        }

        if (!passwordEncoder.matches((String) usernamePasswordAuthenticationToken.getCredentials(), userDetails.getPassword())) {
            userService.loginFailed(userDetailsDTO);
            throw new BadCredentialsException("Invalid credentials.");
        }

        if(userDetailsDTO.getNumberOfAttempts()> 0) {
            userService.loginSucceeded(userDetailsDTO.getId());
        }
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return this.userService.loadUserByUsername(s);
    }
}
