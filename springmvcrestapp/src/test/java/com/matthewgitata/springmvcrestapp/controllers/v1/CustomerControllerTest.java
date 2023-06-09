package com.matthewgitata.springmvcrestapp.controllers.v1;

import com.matthewgitata.springmvcrestapp.api.v1.model.CustomerDTO;
import com.matthewgitata.springmvcrestapp.controllers.RestResponseEntityExceptionHandler;
import com.matthewgitata.springmvcrestapp.services.CustomerService;

import java.util.Arrays;

import static com.matthewgitata.springmvcrestapp.controllers.v1.AbstractRestControllerTest.asJsonString;
import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 23/03/2023.
 */
class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectedMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders().standAloneSetup(customerController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @org.junit.jupiter.api.Test
    public void testListCustomers() throws Exception {
        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customer1.setCustomerUrl(CustomerController.BASE_URL+"/1");

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");
        customer1.setCustomerUrl(CustomerController.BASE_URL+"/2");

        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer1, customer2));

        mockMvc.perform(get(CustomerController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(2)));
    }

    @org.junit.jupiter.api.Test
    public void testGetCustomerById() throws Exception {

        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customer1.setCustomUrl(CustomerController.BASE_URL+"/1");

        when(customerService.getCustomerById(anyLong())).thenReturn(customer1);

        //when
        mockMvc.perform(get(CustomerController.BASE_URL+"/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName", equalTo("Michale")));
    }

    @org.junit.jupiter.api.Test
    public void createNewCustomer() throws Exception {
        //given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstName("Fred");
        customer.setLastName("Flinstone");

        CustomerDTO returnDto = new CustomerDTO();
        returnDto.setFirstName(customer.getFirstName());
        returnDto.setLastName(customer.getLastName());
        returnDto.setCustomerUrl(CustomerController.BASE_URL+"/1");

        when(customerService.createNewCustomer(customer)).thenReturn(returnDto);

        mockMvc.perform(post(CustomerController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", equalTo("Fred")))
                .andExpect(jsonPath("$.customer_url", equalTo(CustomerController.BASE_URL+"1")));
    }

    @org.junit.jupiter.api.Test
    public void testUpdateCustomer() throws Exception {
        //given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstName("Fred");
        customer.setLastName("Flinstone");

        CustomerDTO returnDto = new CustomerDTO();
        returnDto.setFirstName(customer.getFirstName());
        returnDto.setLastName(customer.getLastName());
        returnDto.setCustomerUrl(CustomerController.BASE_URL+"1");

        when(customerService.saveCustomerByDTO(anyLong(), customer)).thenReturn(returnDto);


        //when/then
        mockMvc.perform(put(CustomerController.BASE_URL+"1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo("Fred")))
                .andExpect(jsonPath("$.lastname", equalTo("Flinstone")))
                .andExpect(jsonPath("$.customer_url", equalTo(CustomerController.BASE_URL+"/1")));
    }

    @org.junit.jupiter.api.Test
    public void testPatchCustomer() throws Exception {
        //given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstName("Fred");

        CustomerDTO returnDto = new CustomerDTO();
        returnDto.setFirstName(customer.getFirstName());
        returnDto.setLastName("Flinstone");
        returnDto.setCustomerUrl(CustomerController.BASE_URL+"/1");

        when(customerService.patchCustomer(anyLong(), any(CustomerDTO.class))).thenReturn(returnDto);

        //when/then
        mockMvc.perform(patch(CustomerController.BASE_URL+"/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo("Fred")))
                .andExpect(jsonPath("$.lastname", equalTo("Flinstone")))
                .andExpect(jsonPath("$customer_url", equalTo(CustomerController.BASE_URL+"/1")));
    }

    @org.junit.jupiter.api.Test
    public void testDeleteCustomer() throws Exception {
        mockMvc.perform(delete(CustomerController.BASE_URL+"/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(customerService).deleteCustomerById(anyLong());
    }

}