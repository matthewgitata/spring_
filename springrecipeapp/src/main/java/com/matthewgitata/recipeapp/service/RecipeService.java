package com.matthewgitata.recipeapp.service;

import com.matthewgitata.recipeapp.domain.Recipe;

import java.util.Set;

/**
 * created by @matthewgitata on 19/03/2023
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
}