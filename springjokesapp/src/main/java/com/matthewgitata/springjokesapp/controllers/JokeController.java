package com.matthewgitata.springjokesapp.controllers;

import com.matthewgitata.springjokesapp.services.JokesService;

/**
 * created by @matthewgitata on 17/03/2023.
 */
@Controller
public class JokeController {

    private final JokesService jokesService;

    public JokeController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokesService.getJoke());

        return "index";
    }
}