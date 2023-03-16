package com.matthewgitata.springdi.services;

/**
 * created by @matthewgitata on 16/03/2023
 */
@Service
public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - Setter";
    }
}