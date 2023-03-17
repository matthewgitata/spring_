package com.matthewgitata.petclinic.services;

import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}