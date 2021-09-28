package com.csp.user.mapper;

import com.csp.user.domain.User;
import com.csp.user.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface UserMapper {

    User mapUserDTOToUSer(UserDTO userDTO);

    @Mapping(source = "role.id", target = "roleId")
    UserDTO mapUserToUSerDTO(User user);
}
