package com.csp.authorization.service.user;

import com.csp.authorization.domain.User;
import com.csp.authorization.mapper.UserMapper;
import com.csp.authorization.model.UserDetailsDTO;
import com.csp.authorization.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    // This methods gets the user saved in db and maps it to UserDetails
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByUserName(userName);
        user.orElseThrow(() ->new UsernameNotFoundException("User not Found"));
        UserDetailsDTO userDetailsDTO = userMapper.mapUserToUserDetailsDTO(user.get());
        return userDetailsDTO;
    }
}
