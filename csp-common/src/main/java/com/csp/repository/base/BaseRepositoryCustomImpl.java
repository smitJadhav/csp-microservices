package com.csp.repository.base;

import javax.persistence.EntityManager;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

public abstract class BaseRepositoryCustomImpl {

    protected EntityManager entityManager;

    public BaseRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <V extends Object> V getReference(Class type, Long id) {
        if (id != null) {
            return (V) entityManager.getReference(type, id);
        }
        return null;
    }

    public <V extends Object> V getReference(Class type, String id) {
        if (id != null) {
            return (V) entityManager.getReference(type, id);
        }
        return null;
    }
}
