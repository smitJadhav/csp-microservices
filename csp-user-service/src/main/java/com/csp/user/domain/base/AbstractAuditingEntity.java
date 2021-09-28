package com.csp.user.domain.base;

import com.csp.domain.base.AbstractEntity;
import com.csp.user.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Getter
@Setter
@MappedSuperclass
public class AbstractAuditingEntity extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
    @CreatedBy
    private User createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by")
    @LastModifiedBy
    private User modifiedBy;
}
