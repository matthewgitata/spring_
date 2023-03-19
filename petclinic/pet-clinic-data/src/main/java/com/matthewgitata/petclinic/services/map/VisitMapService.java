package com.matthewgitata.petclinic.services.map;

import com.matthewgitata.petclinic.model.Visit;
import com.matthewgitata.petclinic.services.VisitService;

import java.util.Set;

/**
 * created by @matthewgitata on 19/03/2023
 */
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        } else {
            return super.save(visit);
        }
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}