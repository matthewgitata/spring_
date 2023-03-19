package com.matthewgitata.recipeapp.controllers;


import com.matthewgitata.recipeapp.service.RecipeService;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @org.junit.jupiter.api.Test
    void getIndexPage() throws Exception {
        String viewName = controller.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}