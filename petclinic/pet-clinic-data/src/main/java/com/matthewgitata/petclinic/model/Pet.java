package com.matthewgitata.petclinic.model;

import java.time.LocalDate;

/**
 * The {@code Pet} class is a simple JavaBean domain
 * object representing a pet.
 * <p>
 * created by @matthewgitata on 17/03/2023.
 */
public class Pet {
    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}