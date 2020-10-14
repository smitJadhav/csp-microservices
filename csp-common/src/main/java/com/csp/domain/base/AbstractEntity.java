package com.csp.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;
}
