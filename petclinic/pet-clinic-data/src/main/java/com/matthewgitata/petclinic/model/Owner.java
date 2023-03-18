package com.matthewgitata.petclinic.model;

import java.util.Set;

/**
 * The {@code Owner} class is a simple JavaBean domain
 * object representing an owner.
 * <p>
 * created by @matthewgitata on 17/03/2023
 */
public class Owner extends Person {
    private Set<Pet> pets;
}