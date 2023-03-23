package com.matthewgitata.springmvcrestapp.domain;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
}