package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();

        controller.greetingService = new GreetingServiceImpl();
    }

    @org.junit.jupiter.api.Test
    void sayGreeting() {
        controller.sayGreeting();
    }
}