package com.csp.authorization.mapper;

import com.csp.authorization.domain.User;
import com.csp.authorization.model.UserDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(source = "user.role.name", target = "role")
    UserDetailsDTO mapUserToUserDetailsDTO(User user);
}
