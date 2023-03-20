package com.matthewgitata.petclinic.services.springdatajpa;

import com.matthewgitata.petclinic.model.Vet;
import com.matthewgitata.petclinic.repositories.VetRepository;
import com.matthewgitata.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

/**
 * created by @matthewgitata on 19/03/2023
 */
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}