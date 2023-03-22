package com.matthewgitata.recipeapp.controllers;

import com.matthewgitata.recipeapp.domain.Recipe;
import com.matthewgitata.recipeapp.service.RecipeService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 20/03/2023
 */
class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new RecipeController(recipeService);
    }

    @org.junit.jupiter.api.Test
    public void testGetRecipe() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }
}