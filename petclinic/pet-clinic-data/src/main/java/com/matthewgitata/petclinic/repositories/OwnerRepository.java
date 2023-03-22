package com.matthewgitata.petclinic.repositories;

import com.matthewgitata.petclinic.model.Owner;

import java.util.List;

/**
 * created by @matthewgitata on 19/03/2023
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}