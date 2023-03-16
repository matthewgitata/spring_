package com.matthewgitata.springdi.services;

/**
 * created by @matthewgitata on 16/03/2023
 */
@Service
public class PropertyInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}