package com.matthewgitata.petclinic.model;

/**
 * The {@code Person} class is a simple JavaBean domain
 * object representing a person.
 * <p>
 * created by @matthewgitata on 17/03/2023
 */
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}