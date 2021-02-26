package com.csp.authorization.service.user;

import com.csp.authorization.domain.User;
import com.csp.authorization.mapper.UserMapper;
import com.csp.authorization.model.UserDetailsDTO;
import com.csp.authorization.repository.user.UserRepository;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Service
public class UserServiceImpl implements UserService {

    private static final String MAX_LOGIN_ATTEMPTS_PROP = "oauth.max.login.attempts";

    private UserRepository userRepository;
    private UserMapper userMapper;
    private int maxLoginAttempts;

    public UserServiceImpl(Environment environment, UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.maxLoginAttempts = Integer.parseInt(environment.getProperty(MAX_LOGIN_ATTEMPTS_PROP, "3"));
    }

    // This methods gets the user saved in db and maps it to UserDetails
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByUserName(userName);
        user.orElseThrow(() ->new UsernameNotFoundException(String.format("User with the username %s doesn't exists", userName)));
        UserDetailsDTO userDetailsDTO = userMapper.mapUserToUserDetailsDTO(user.get());
        return userDetailsDTO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void loginFailed(UserDetailsDTO userDetailsDTO) {
        Integer numberOfAttempts = userDetailsDTO.getNumberOfAttempts();
        if(numberOfAttempts >= maxLoginAttempts){
            userRepository.lockUser(userDetailsDTO.getId());
        } else if(numberOfAttempts < maxLoginAttempts){
            userRepository.updateLoginAttempts(userDetailsDTO.getId(), numberOfAttempts);
        }
    }

    @Transactional
    public void loginSucceeded(Long userId){
        userRepository.updateLoginAttempts(userId, 0);
    }
}
