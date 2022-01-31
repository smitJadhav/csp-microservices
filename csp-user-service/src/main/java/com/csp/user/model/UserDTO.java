package com.csp.user.model;

import com.csp.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private Gender gender;
    private Long roleId;
}
