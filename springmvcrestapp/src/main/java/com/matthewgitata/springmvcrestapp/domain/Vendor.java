package com.matthewgitata.springmvcrestapp.domain;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Data
@Entity
public class Vendor {
    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}