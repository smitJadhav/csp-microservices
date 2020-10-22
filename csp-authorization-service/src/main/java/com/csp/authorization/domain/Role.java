package com.csp.authorization.domain;

import com.csp.domain.base.AbstractEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends AbstractEntity implements Serializable {

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    private String description;
}
