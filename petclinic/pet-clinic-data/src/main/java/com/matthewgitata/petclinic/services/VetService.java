package com.matthewgitata.petclinic.services;

import com.matthewgitata.petclinic.model.Vet;

import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}