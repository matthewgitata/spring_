package com.matthewgitata.petclinic.controllers;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 20/03/2023
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        owners = new HashSet<Owner>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @org.junit.jupiter.api.Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().addAttribute("owners", hasSize(2)));
    }

    @org.junit.jupiter.api.Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().addAttribute("owners", hasSize(2)));
    }

    @org.junit.jupiter.api.Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));
        verifyZeroInteractions(ownerService);
    }
}