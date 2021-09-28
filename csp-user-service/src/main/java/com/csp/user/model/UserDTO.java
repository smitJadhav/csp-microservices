package com.csp.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private String secondaryEmail;
    private Long roleId;
}
