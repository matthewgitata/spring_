package com.matthewgitata.petclinic.services;

import com.matthewgitata.petclinic.model.Owner;

/**
 * created by @matthewgitata on 17/03/2023
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}