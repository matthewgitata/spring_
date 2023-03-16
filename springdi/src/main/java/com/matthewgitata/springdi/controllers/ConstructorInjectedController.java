package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.GreetingService;

/**
 * created by @matthewgitata on 16/03/2023
 */
public class ConstructorInjectedController {
    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}