package com.matthewgitata.demo.controllers;

import com.matthewgitata.demo.repositories.BookRepository;

/**
 * The {@code BookController} class configures a Book
 * Controller associating its methods with request
 * paths.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAtrribute("books", bookRepository.findAll());

        return "books";
    }
}