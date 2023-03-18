package com.matthewgitata.petclinic.model;

import java.time.LocalDate;

/**
 * The {@code Visit} class is a simple JavaBean domain
 * object representing a visit.
 * <p>
 * created by @matthewgitata on 18/03/2023.
 */
public class Visit extends BaseEntity{
    private LocalDate date;
    private String description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}