package com.matthewgitata.springmvcrestapp.controllers;

import com.matthewgitata.springmvcrestapp.services.ResourceNotFoundException;

import java.net.http.HttpHeaders;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>("Resource Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}