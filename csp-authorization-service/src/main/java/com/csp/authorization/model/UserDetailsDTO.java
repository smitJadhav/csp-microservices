package com.csp.authorization.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Smit.Jadhav on 10/3/2020
 */

@Getter
@Setter
public class UserDetailsDTO implements UserDetails {

    private Long id;
    private String userName;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String email;
    private boolean isNonLocked;
    private boolean isActive;
    private Integer numberOfAttempts;
    private String statusChangeReason;
    private String gender;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return AuthorityUtils.createAuthorityList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
