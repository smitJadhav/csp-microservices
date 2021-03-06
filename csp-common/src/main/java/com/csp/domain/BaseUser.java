package com.csp.domain;

import com.csp.domain.base.AbstractEntity;
import com.csp.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@MappedSuperclass
@Getter
@Setter
public class BaseUser extends AbstractEntity {

    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private boolean isNonLocked;
    private boolean isActive;
    private boolean isPasswordAutogenerated;
    private Integer numberOfAttempts;
    private String statusChangeReason;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
