package com.matthewgitata.recipeapp.repositories;

import com.matthewgitata.recipeapp.domain.Category;

import java.util.Optional;

/**
 * created by @matthewgitata on 18/03/2023
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}