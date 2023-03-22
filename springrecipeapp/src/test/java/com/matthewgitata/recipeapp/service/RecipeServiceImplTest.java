package com.matthewgitata.recipeapp.service;

import com.matthewgitata.recipeapp.domain.Recipe;
import com.matthewgitata.recipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 20/03/2023
 */
class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @org.junit.jupiter.api.Test
    void getRecipesByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never().findAll());
    }

    @org.junit.jupiter.api.Test
    void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}