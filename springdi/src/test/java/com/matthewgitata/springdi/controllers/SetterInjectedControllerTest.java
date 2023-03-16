package com.matthewgitata.springdi.controllers;

import com.matthewgitata.springdi.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new GreetingServiceImpl());
    }

    @org.junit.jupiter.api.Test
    void sayGreeting() {
        System.out.println(controller.sayGreeting());
    }
}