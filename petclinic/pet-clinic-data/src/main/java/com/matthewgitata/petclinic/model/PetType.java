package com.matthewgitata.petclinic.model;

/**
 * The {@code PetType} class is a simple JavaBean domain
 * object representing a pet type.
 * <p>
 * created by @matthewgitata on 17/03/2023.
 */
@Entity
@Table(name="types")
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}