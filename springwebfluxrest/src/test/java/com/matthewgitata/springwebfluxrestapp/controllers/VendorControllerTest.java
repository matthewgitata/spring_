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

    @org.junit.jupiter.api.Test
    public void testCreateVendor() {
        BDDMockito.given(vendorRepository.saveAll(any(Publisher.class)))
                .willReturn(Flux.just(Vendor.builder().build()));

        Mono<Vendor> vendorToSaveMono = Mono.just(Vendor.builder().firstName("First Name")
                .lastName("Name Name")).build();

        webTestClient.post()
                .uri("/api/v1/vendors")
                .body(vendorToSaveMono, Vendor.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @org.junit.jupiter.api.Test
    public void testUpdate() {
        BDDMockito.given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdateMono = Mono.just(Vendor.builder().firstName("First Name")
                .lastName("Last Name").build());

        webTestClient.put()
                .uri("/api/v1/vendors/someid")
                .body(vendorToUpdateMono, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @org.junit.jupiter.api.Test
    public void testPatchVendorWithChanges() {
        given(vendorRepository.findById(anyString()))
                .willReturn(Mono.just(Category.builder().firstName("Jimmy").build()));

        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdate = Mono.just(Vendor.builder().firstName("Jim").build());

        webTestClient.patch()
                .uri("/api/v1/vendors/someid")
                .body(vendorToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(vendorRepository).save(any());
    }

    @org.junit.jupiter.api.Test
    public void testPatchVendorWithoutChanges() {
        given(vendorRepository.findById(anyString()))
                .willReturn(Mono.just(Category.builder().firstName("Jimmy").build()));

        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdate = Mono.just(Vendor.builder().firstName("Jimmy").build());

        webTestClient.patch()
                .uri("/api/v1/vendors/someid")
                .body(vendorToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(vendorRepository, never()).save(any());
    }
}