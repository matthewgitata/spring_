package com.matthewgitata.springwebapp.repositories;

import com.matthewgitata.springwebapp.domain.Author;

/**
 * The {@code AuthorRepository} class represents an
 * Author repository. It sets up a CRUD repository.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}