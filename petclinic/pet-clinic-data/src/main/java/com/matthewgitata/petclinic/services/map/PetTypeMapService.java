package com.matthewgitata.petclinic.services.map;

import com.matthewgitata.petclinic.model.PetType;
import com.matthewgitata.petclinic.services.PetTypeService;

import java.util.Set;

/**
 * created by @matthewgitata on 18/03/2023
 */
@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
