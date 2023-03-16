package com.matthewgitata.springdi.services;

/**
 * created by @matthewgitata on 16/03/2023
 */
@Primary
@Service
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean";
    }
}