package com.matthewgitata.petclinic.services.map;

import com.matthewgitata.petclinic.model.Vet;
import com.matthewgitata.petclinic.services.CrudService;

import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}