package com.matthewgitata.demo.repositories;

import com.matthewgitata.demo.domain.Book;

/**
 * The {@code BookRepository} class represents a
 * Book repository. It sets up a CRUD repository.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}