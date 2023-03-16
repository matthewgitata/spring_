package com.matthewgitata.springwebapp.controllers;

import com.matthewgitata.springwebapp.repositories.AuthorRepository;

/**
 * The {@code AuthorController} class configures an Author
 * Controller associating its methods with request
 * paths.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
