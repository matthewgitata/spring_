package com.matthewgitata.recipeapp.controllers;

import com.matthewgitata.recipeapp.service.RecipeService;

/**
 * created by @matthewgitata on 18/03/2023
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}