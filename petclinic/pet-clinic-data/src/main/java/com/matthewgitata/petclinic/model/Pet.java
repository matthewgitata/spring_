package com.matthewgitata.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Pet} class is a simple JavaBean domain
 * object representing a pet.
 * <p>
 * created by @matthewgitata on 17/03/2023.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}