package com.matthewgitata.petclinic.model;

/**
 * The {@code Specialy} class is a simple JavaBean domain
 * object representing a specialty.
 * <p>
 * created by @matthewgitata on 18/03/2023.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {
    @Column(name = "description")
    private String description;
}