package com.matthewgitata.springwebapp.repositories;

import com.matthewgitata.springwebapp.domain.Book;

/**
 * The {@code BookRepository} class represents a
 * Book repository. It sets up a CRUD repository.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}