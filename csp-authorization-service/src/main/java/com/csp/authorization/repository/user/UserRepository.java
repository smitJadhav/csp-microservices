package com.csp.authorization.repository.user;

import com.csp.authorization.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Smit.Jadhav on 10/3/2020
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);

    @Modifying
    @Query("UPDATE User user SET user.isNonLocked = false WHERE user.id =:userId")
    void lockUser(@Param("userId") Long userId);

    @Modifying
    @Query("UPDATE User user SET user.numberOfAttempts =:loginAttempts WHERE user.id =:userId")
    void updateLoginAttempts(@Param("userId") Long userId, @Param("loginAttempts") Integer loginAttempts);
}
