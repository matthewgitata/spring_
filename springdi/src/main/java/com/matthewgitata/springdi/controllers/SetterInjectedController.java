package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.GreetingService;

/**
 * created by @matthewgitata on 16/03/2023
 */
public class SetterInjectedController {
    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}