package com.matthewgitata.springrestclientexamples.services;

import com.matthewgitata.api.domain.User;

import java.util.List;

/**
 * created by @matthewgitata on 22/03/2023.
 */
public interface ApiService {
    List<User> getUsers(Integer limit);
}