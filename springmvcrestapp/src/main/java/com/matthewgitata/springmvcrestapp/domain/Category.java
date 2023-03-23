package com.matthewgitata.springmvcrestapp.domain;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Data
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
}