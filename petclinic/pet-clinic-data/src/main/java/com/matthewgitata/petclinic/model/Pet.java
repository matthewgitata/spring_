package com.matthewgitata.petclinic.model;

import java.time.LocalDate;

/**
 * The {@code Pet} class is a simple JavaBean domain
 * object representing a pet.
 * <p>
 * created by @matthewgitata on 17/03/2023.
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn("type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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