package com.matthewgitata.springwebfluxrestapp.repository;

import com.matthewgitata.springwebfluxrestapp.domain.Category;

/**
 * created by @matthewgitata on 24/03/2023.
 */
public interface CategoryRepository extends ReactiveMongoRepository <Category, String> {
}