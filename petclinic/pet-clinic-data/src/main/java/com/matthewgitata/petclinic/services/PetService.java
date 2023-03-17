package com.matthewgitata.petclinic.services;

import com.matthewgitata.petclinic.model.Pet;

import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}