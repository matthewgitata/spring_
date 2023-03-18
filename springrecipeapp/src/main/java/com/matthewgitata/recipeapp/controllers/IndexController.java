package com.matthewgitata.recipeapp.controllers;

import com.matthewgitata.recipeapp.domain.Category;
import com.matthewgitata.recipeapp.domain.UnitOfMeasure;
import com.matthewgitata.recipeapp.repositories.CategoryRepository;
import com.matthewgitata.recipeapp.repositories.UnitOfMeasureRepository;

import java.util.Optional;

/**
 * created by @matthewgitata on 18/03/2023
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}