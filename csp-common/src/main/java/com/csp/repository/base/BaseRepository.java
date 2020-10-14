package com.csp.repository.base;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

public interface BaseRepository {
    <v extends Object> v getReference(Class type, Long id);
    <v extends Object> v getReference(Class type, String id);
}
