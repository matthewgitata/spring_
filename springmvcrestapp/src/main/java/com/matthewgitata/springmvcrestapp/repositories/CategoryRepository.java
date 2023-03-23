package com.matthewgitata.springmvcrestapp.repositories;

import com.matthewgitata.springmvcrestapp.domain.Category;

/**
 * created by @matthewgitata on 23/03/2023.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}