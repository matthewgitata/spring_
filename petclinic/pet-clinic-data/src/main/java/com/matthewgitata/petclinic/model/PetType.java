package com.matthewgitata.petclinic.model;

/**
 * The {@code PetType} class is a simple JavaBean domain
 * object representing a pet type.
 * <p>
 * created by @matthewgitata on 17/03/2023.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}