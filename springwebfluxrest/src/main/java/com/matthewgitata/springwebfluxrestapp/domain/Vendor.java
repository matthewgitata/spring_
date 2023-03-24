package com.matthewgitata.springwebfluxrestapp.domain;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@Data
@Document
public class Vendor {
    @Id
    private String id;
    private String firstName;
    private String lastName;
}