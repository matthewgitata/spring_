package com.matthewgitata.petclinic.controllers;

/**
 * created by @matthewgitata on 17/03/2023
 */
@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets() {
        return "vets/index";
    }
}
