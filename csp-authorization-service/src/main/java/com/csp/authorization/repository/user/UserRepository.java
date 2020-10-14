package com.csp.authorization.repository.user;

import com.csp.authorization.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Smit.Jadhav on 10/3/2020
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);
}
