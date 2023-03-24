package com.matthewgitata.springwebfluxrestapp.controllers;

import com.matthewgitata.springwebfluxrestapp.domain.Category;
import com.matthewgitata.springwebfluxrestapp.repository.CategoryRepository;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/api/v1/categories")
    Flux<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/v1/categories/{id}")
    Mono<Category> getById() {
        return categoryRepository.findById(id);
    }
}