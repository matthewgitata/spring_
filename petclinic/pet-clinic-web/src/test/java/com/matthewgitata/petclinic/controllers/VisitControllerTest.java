package com.matthewgitata.petclinic.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 22/03/2023
 */
@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    private static final String PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
    public static final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
    public static final String YET_ANOTHER_VISIT_DESCRIPTION = "yet another visit";

    @Mock
    PetService petService;

    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    private MockMvc mockMvc;

    private final UrlTemplate visitUriTemplate = new UrlTemplate("/owners/{ownerId}/pets/visits/new");
    private final Map<String, String> uriVariables = new HashMap<String, String>();
    private URI visitsUri;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Long petId = 1L;
        Long ownerId = 1L;
        when(petService.findById(anyLong()))
                .thenReturn(
                        Pet.builder()
                                .id(petId)
                                .birthDate(LocalDate.of(2018, 11, 13))
                                .name("Baddie")
                                .visits(new HashSet<>())
                                .owner(Owner.builder()
                                        .id(ownerId)
                                        .lastName("Doe")
                                        .firstName("John")
                                        .build())
                                .petType(PetType.builder()
                                        .name("Dog").build())
                                .build()
                );
        uriVariables.clear();
        uriVariables.put("ownerId", ownerId.toString());
        uriVariables.put("petId", petId.toString());
        visitsUri = visitUrlTemplate.expand(uriVariables);

        mockMvc = MockMvcBuilders
                .standAloneSetup(visitController)
                .build();
    }

    @org.junit.jupiter.api.Test
    void initNewVisitForm() throws Exception {
        mockMvc.perform(get(visitsUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PETS_CREATE_OR_UPDATE_VISIT_FORM));
    }

    @org.junit.jupiter.api.Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitsUri)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("date", "2018-11-11")
                        .param("description", YET_ANOTHER_VISIT_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpectView(view().name(REDIRECT_OWNERS_1))
                .andExpect(model().attributeExists("visit"));
    }
}