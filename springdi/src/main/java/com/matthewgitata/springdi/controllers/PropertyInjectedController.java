package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.GreetingService;

/**
 * created by @matthewgitata on 16/03/2023
 */
public class PropertyInjectedController {

    public GreetingService greetingService;

    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}
