package com.matthewgitata.springmvcrestapp.controllers.v1;

/**
 * created by @matthewgitata on 23/03/2023.
 */
public abstract class AbstractRestControllerTest {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}