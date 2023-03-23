package com.matthewgitata.springmvcrestapp.controllers.v1;

import com.matthewgitata.springmvcrestapp.api.v1.model.CategoryDTO;
import com.matthewgitata.springmvcrestapp.api.v1.model.CategoryListDTO;
import com.matthewgitata.springmvcrestapp.services.CategoryService;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}