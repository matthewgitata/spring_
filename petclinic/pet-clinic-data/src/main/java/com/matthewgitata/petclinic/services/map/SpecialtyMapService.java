package com.matthewgitata.petclinic.services.map;

import com.matthewgitata.petclinic.model.Specialty;
import com.matthewgitata.petclinic.services.SpecialtyService;

import java.util.Set;

/**
 * created by @matthewgitata on 18/03/2023
 */
@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}