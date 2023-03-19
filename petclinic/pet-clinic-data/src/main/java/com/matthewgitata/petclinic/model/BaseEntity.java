package com.matthewgitata.petclinic.model;

import java.io.Serializable;

/**
 * created by @matthewgitata on 17/03/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperClass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}