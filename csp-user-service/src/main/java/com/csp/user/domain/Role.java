package com.csp.user.domain;

import com.csp.user.domain.base.AbstractAuditingEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "role")
@Entity
@Getter
@Setter
public class Role extends AbstractAuditingEntity {

    private String name;
    private String description;

}
