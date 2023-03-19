package com.matthewgitata.recipeapp.controllers;

import com.matthewgitata.recipeapp.domain.Recipe;
import com.matthewgitata.recipeapp.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @org.junit.jupiter.api.Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @org.junit.jupiter.api.Test
    void getIndexPage() throws Exception {
        // Given
        Set<Recipe> recipes = new HashSet<Recipe>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipes.add(recipe);

        // When
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = controller.getIndexPage(model);

        // then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}