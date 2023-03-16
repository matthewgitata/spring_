package com.matthewgitata.springwebapp.repositories;

import com.matthewgitata.springwebapp.domain.Publisher;

/**
 * The {@code PublisherRepository} class represents a
 * Publisher repository. It sets up a CRUD repository.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}