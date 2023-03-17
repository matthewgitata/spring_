package com.matthewgitata.petclinic.services;

import com.matthewgitata.petclinic.model.Owner;

import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}