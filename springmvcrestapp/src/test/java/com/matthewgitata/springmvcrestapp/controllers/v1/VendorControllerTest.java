package com.matthewgitata.springmvcrestapp.controllers.v1;

import com.matthewgitata.springmvcrestapp.api.v1.model.VendorDTO;
import com.matthewgitata.springmvcrestapp.api.v1.model.VendorListDTO;
import com.matthewgitata.springmvcrestapp.services.VendorService;

import java.util.Arrays;

import static com.matthewgitata.springmvcrestapp.controllers.v1.AbstractRestControllerTest.asJsonString;
import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {VendorController.class})
class VendorControllerTest {

    @MockBean
    VendorService vendorService;

    @Autowired
    MockMvc mockMvc;

    VendorDTO vendorDTO_1;
    VendorDTO vendorDTO_2;


    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        vendorDTO_1 = new VendorDTO("Vendor 1", VendorController.BASE_URL + "/1");
        vendorDTO_1 = new VendorDTO("Vendor 2", VendorController.BASE_URL + "/2");
    }

    @org.junit.jupiter.api.Test
    public void getVendorList() throws Exception {
        VendorListDTO vendorListDTO = new VendorListDTO(Arrays.asList(vendorDTO_1, vendorDTO_2));

        given(vendorService.getAllVendors()).willReturn(vendorListDTO);

        mockMvc.perform(get(VendorController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(2)));
    }

    @org.junit.jupiter.api.Test
    public void getVendorById() throws Exception {
        given(vendorService.getVendorById(anyLong())).willReturn(vendorDTO_1);

        mockMvc.perform(get(VendorController.BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())));
    }

    @org.junit.jupiter.api.Test
    public void createNewVendor() throws Exception {
        given(vendorService.createNewVendor(vendorDTO_1)).willReturn(vendorDTO_1);

        mockMvc.perform(post(VendorController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(vendorDTO_1)))
                .andExpect(status().isk())
                .andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())));
    }

    @org.junit.jupiter.api.Test
    public void updateVendor() throws Exception {
        given(vendorService.saveVendorByDTO(anyLong(), any(VendorDTO.class))).willReturn(vendorDTO_1);

        mockMvc.perform(put(VendorController.BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .content(asJsonString(vendorDTO_1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())));
    }

    @org.junit.jupiter.api.Test
    public void patchVendor() throws Exception {
        given(vendorService.saveVendorByDTO(anyLong(), any(VendorDTO.class))).willReturn(vendorDTO_1);

        mockMvc.perform(patch(VendorController.BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(vendorDTO_1)))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())));
    }

    @org.junit.jupiter.api.Test
    public void deleteVendor() throws Exception {
        mockMvc.perform(delete(VendorController.BASE_URL + "/1"))
                .andExpect(status().isOk());

        then(vendorService).should().deleteVendorById(anyLong());
    }
}