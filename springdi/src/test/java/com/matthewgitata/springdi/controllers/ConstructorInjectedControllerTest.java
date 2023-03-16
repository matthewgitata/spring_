package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.ConstructorGreetingService;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @org.junit.jupiter.api.Test
    void sayGreeting() {
        System.out.println(controller.sayGreeting());
    }
}