package com.matthewgitata.petclinic.model;

import java.io.Serializable;

/**
 * created by @matthewgitata on 17/03/2023
 */
@MappedSuperClass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}