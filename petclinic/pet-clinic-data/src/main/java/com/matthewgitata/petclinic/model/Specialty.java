package com.matthewgitata.petclinic.model;

/**
 * The {@code Specialy} class is a simple JavaBean domain
 * object representing a specialty.
 * <p>
 * created by @matthewgitata on 18/03/2023.
 */
public class Specialty extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}