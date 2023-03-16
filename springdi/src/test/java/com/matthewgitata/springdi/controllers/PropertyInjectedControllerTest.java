package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.ConstructorGreetingService;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();

        controller.greetingService = new ConstructorGreetingService();
    }

    @org.junit.jupiter.api.Test
    void sayGreeting() {
        controller.sayGreeting();
    }
}