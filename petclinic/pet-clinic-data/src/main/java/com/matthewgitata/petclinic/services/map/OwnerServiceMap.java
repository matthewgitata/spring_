package com.matthewgitata.petclinic.services.map;

import com.matthewgitata.petclinic.model.Owner;
import com.matthewgitata.petclinic.services.CrudService;
import java.util.Set;

/**
 * created by @matthewgitata on 17/03/2023
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

}