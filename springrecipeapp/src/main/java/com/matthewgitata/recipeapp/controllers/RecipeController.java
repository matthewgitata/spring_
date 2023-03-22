package com.matthewgitata.recipeapp.controllers;

import com.matthewgitata.recipeapp.service.RecipeService;

/**
 * created by @matthewgitata on 20/03/2023
 */
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipes/show";
    }
}