package com.matthewgitata.petclinic.controllers;

/**
 * created by @matthewgitata on 17/03/2023
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}