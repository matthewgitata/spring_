package com.matthewgitata.springwebfluxrestapp.controllers;

import com.matthewgitata.springwebfluxrestapp.domain.Vendor;
import com.matthewgitata.springwebfluxrestapp.repository.VendorRepository;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@RestController
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GetMapping("/api/v1/vendors")
    Flux<Vendor> list() {
        return vendorRepository.findAll();
    }

    @GetMapping("/api/v1/vendor/{id}")
    Mono<Vendor> getById(@PathVariable String id) {
        return vendorRepository.findById(id);
    }

}