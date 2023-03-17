package com.matthewgitata.petclinic.controllers;

/**
 * created by @matthewgitata on 17/03/2023
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
}
