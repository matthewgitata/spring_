package com.matthewgitata.recipeapp.repositories;

import com.matthewgitata.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

/**
 * created by @matthewgitata on 18/03/2023
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}