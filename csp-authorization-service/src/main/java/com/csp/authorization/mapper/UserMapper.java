package com.csp.authorization.mapper;

import com.csp.authorization.domain.User;
import com.csp.authorization.model.UserDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Smit.Jadhav on 14-10-2020.
 */

@Mapper
public interface UserMapper {

    @Mapping(source = "user.role.name", target = "role")
    UserDetailsDTO mapUserToUserDetailsDTO(User user);
}
