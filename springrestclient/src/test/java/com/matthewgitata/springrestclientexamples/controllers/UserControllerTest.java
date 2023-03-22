package com.matthewgitata.springrestclientexamples.controllers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 22/03/2023.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    ApplicationContext applicationContext;

    WebTestClient webTestClient;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();
    }

    @org.junit.jupiter.api.Test
    public void index() throws Exception {
        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk();
    }

    @org.junit.jupiter.api.Test
    public void formPost() throws Exception {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("limit", "3");

        webTestClient.post().uri("users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .exchange()
                .expectStatus().isOk();
    }
}