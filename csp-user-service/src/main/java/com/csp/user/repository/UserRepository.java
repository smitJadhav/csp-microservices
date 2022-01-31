package com.csp.user.repository;

import com.csp.user.domain.User;
import com.csp.user.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.csp.user.model.UserDTO(u.id, u.userName, u.firstName, u.middleName, u.lastName, u.email, u.phone, u.gender, u.role.id) from User u where u.id= :id")
    public UserDTO findUserById(@Param("id") Long id);

}
