package com.matthewgitata.springwebfluxrestapp.controllers;

import com.matthewgitata.springwebfluxrestapp.domain.Category;
import com.matthewgitata.springwebfluxrestapp.repository.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class CategoryControllerTest {

    WebTestClient webTestClient;

    CategoryRepository categoryRepository;

    CategoryController categoryController;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryController = new CategoryController(categoryRepository);
        webTestClient = WebTestClient.bindToController(categoryController).build();
    }

    @org.junit.jupiter.api.Test
    public void list() throws Exception {
        given(categoryRepository.findAll())
                .willReturn(Flux.just(Category.builder().description("Cat1").build(),
                        Category.builder().description("Cat1").build()));

        webTestClient.get().uri("/api/v1/categories")
                .exchange()
                .expectBodyList(Category.class)
                .hasSize(2);
    }

    @org.junit.jupiter.api.Test
    public void getById() {
        given(categoryRepository.findById("someid"))
                .willReturn(Mono.just(Category.builder().description("Cat1").build()));

        webTestClient.get().uri("/api/v1/categories/someid")
                .exchange()
                .expectBody(Category.class);
    }

    @org.junit.jupiter.api.Test
    public void testCreateCategory() {
        given(categoryRepository.saveAll(any(Publisher.class)))
                .willReturn(Flux.just(Category.builder().description("descrp").build()));

        Mono<Category> catToSaveMono = Mono.just(Category.builder().description("Some Cat").build());

        webTestClient.post()
                .uri("api/v1/categories")
                .body(catToSaveMono, Category.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @org.junit.jupiter.api.Test
    public void testUpdate() {
        given(categoryRepository.save(any(Category.class)))
                .willReturn(Mono.just(Category.builder().build()));

        Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Some Cat").build());

        webTestClient.put()
                .uri("api/v1/categories/someid")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @org.junit.jupiter.api.Test
    public void testPatchWithChanges() {
        given(categoryRepository.findById(anyString()))
                .willReturn(Mono.just(Category.builder().build()));

        given(categoryRepository.save(any(Category.class)))
                .willReturn(Mono.just(Category.builder().build()));

        Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("New Description").build());

        webTestClient.patch()
                .uri("api/v1/categories/someid")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(categoryRepository).save(any());
    }

    @org.junit.jupiter.api.Test
    public void testPatchNoChanges() {
        given(categoryRepository.findById(anyString()))
                .willReturn(Mono.just(Category.builder().build()));

        given(categoryRepository.save(any(Category.class)))
                .willReturn(Mono.just(Category.builder().build()));

        Mono<Category> catToUpdateMono = Mono.just(Category.builder().build());

        webTestClient.patch()
                .uri("api/v1/categories/someid")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(categoryRepository, never()).save(any());
    }
}