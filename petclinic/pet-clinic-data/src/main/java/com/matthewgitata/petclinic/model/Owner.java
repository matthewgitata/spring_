package com.matthewgitata.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Owner} class is a simple JavaBean domain
 * object representing an owner.
 * <p>
 * created by @matthewgitata on 17/03/2023
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBY = "owner")
    private Set<Pet> pets = new HashSet<>();
}