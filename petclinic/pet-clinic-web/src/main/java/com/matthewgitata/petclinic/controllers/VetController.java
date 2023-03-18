package com.matthewgitata.petclinic.controllers;

/**
 * created by @matthewgitata on 17/03/2023
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model mode) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}