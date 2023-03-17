package com.matthewgitata.petclinic.services.map;

import com.matthewgitata.petclinic.model.Pet;
import com.matthewgitata.petclinic.services.PetService;

import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}