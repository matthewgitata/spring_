package com.matthewgitata.petclinic.model;

/**
 * The {@code Person} class is a simple JavaBean domain
 * object representing a person.
 * <p>
 * created by @matthewgitata on 17/03/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperClass
public class Person extends BaseEntity {

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
}