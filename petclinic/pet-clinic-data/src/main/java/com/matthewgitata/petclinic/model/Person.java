package com.matthewgitata.petclinic.model;

/**
 * The {@code Person} class is a simple JavaBean domain
 * object representing a person.
 * <p>
 * created by @matthewgitata on 17/03/2023
 */
@MappedSuperClass
public class Person extends BaseEntity {
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
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