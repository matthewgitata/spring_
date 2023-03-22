package com.matthewgitata.petclinic.model;

import java.time.LocalDate;

/**
 * The {@code Visit} class is a simple JavaBean domain
 * object representing a visit.
 * <p>
 * created by @matthewgitata on 18/03/2023.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}