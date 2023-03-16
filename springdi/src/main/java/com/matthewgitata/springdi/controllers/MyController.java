package com.matthewgitata.springdi.controllers;

/**
 * The {@code MyController} class here is used to show
 * dependency injection in Spring.
 */

@Controller
public class MyController {
    public String sayHello() {
        System.out.println("Hello World!!!");

        return "Hi Folks!";
    }
}