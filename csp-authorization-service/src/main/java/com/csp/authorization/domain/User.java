package com.csp.authorization.domain;

import com.csp.domain.BaseUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Entity
@Table(name = "user_details")
@Getter
@Setter
public class User extends BaseUser implements Serializable{

    @ManyToOne
    private Role role;
}
