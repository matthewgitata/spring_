package com.matthewgitata.springwebfluxrestapp.domain;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@Data
@Document
public class Category {
    @Id
    private String id;
    private String description;
}