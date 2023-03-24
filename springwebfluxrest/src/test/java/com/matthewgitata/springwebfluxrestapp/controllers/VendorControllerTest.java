package com.matthewgitata.springwebfluxrestapp.controllers;

import com.matthewgitata.springwebfluxrestapp.domain.Category;
import com.matthewgitata.springwebfluxrestapp.domain.Vendor;
import com.matthewgitata.springwebfluxrestapp.repository.VendorRepository;

import static org.junit.jupiter.api.Assertions.*;

class VendorControllerTest {

    WebTestClient webTestClient;

    VendorRepository vendorRepository;

    VendorController vendorController;


    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @org.junit.jupiter.api.Test
    public void list() throws Exception {
        BDDMockito.given(vendorRepository.findAll())
                .willReturn(Flux.just(Vendor.builder().firstName("John").lastName("Doe").build(),
                        Vendor.builder().firstName("Jane").lastName("Doe").build()));

        webTestClient.get().uri("/api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @org.junit.jupiter.api.Test
    public void getById() throws Exception {
        BDDMockito.given(vendorRepository.findById("someid"))
                .willReturn(Mono.just(Vendor.builder().firstName("John").lastName("Doe").build()));

        webTestClient.get().uri("/api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);
    }
}