package com.matthewgitata.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Vet} class is a simple JavaBean domain
 * object representing a veterinary.
 * <p>
 * created by @matthewgitata on 17/03/2023
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}