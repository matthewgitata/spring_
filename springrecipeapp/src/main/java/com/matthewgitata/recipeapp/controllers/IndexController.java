package com.matthewgitata.recipeapp.controllers;

/**
 * created by @matthewgitata on 18/03/2023
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index() {
        
        return "index";
    }
}