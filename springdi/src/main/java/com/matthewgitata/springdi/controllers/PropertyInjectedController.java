package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.GreetingService;

/**
 * created by @matthewgitata on 16/03/2023
 */
@Controller
public class PropertyInjectedController {

    @Qualifier("propertyInjectedGreetingService")
    @Autowired
    public GreetingService greetingService;

    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}
