package com.matthewgitata.springmvcrestapp.services;

import com.matthewgitata.springmvcrestapp.api.v1.mapper.CustomerMapper;
import com.matthewgitata.springmvcrestapp.api.v1.model.CustomerDTO;
import com.matthewgitata.springmvcrestapp.bootstrap.Bootstrap;
import com.matthewgitata.springmvcrestapp.domain.Customer;
import com.matthewgitata.springmvcrestapp.repositories.CategoryRepository;
import com.matthewgitata.springmvcrestapp.repositories.CustomerRepository;
import com.matthewgitata.springmvcrestapp.repositories.VendorRepository;

import java.util.List;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplIT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    VendorRepository vendorRepository;

    CustomerService customerService;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        System.out.println("Loading Customer Data");
        System.out.println(customerRepository.findAll().size());

        //setup data for testing
        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository, vendorRepository);
        bootstrap.run(); //load data

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @org.junit.jupiter.api.Test
    public void patchCustomerUpdateFirstName() throws Exception {
        String updatedName = "UpdateName";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);
        //save original first name
        String originalFirstName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(updatedName);

        customerService.patchCustomer(id, customerDTO);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName, updatedCustomer.getFirstName());
        assertThat(originalFirstName, not(equalTo(updatedCustomer.getFirstName())));
        assertThat(originalLastName, equalTo(updatedCustomer.getLastName()));
    }

    @org.junit.jupiter.api.Test
    public void patchCustomerUpdateLastName() throws Exception {
        String updatedName = "UpdateName";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);
        //save original last name
        String originalFirstName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName(updatedName);

        customerService.patchCustomer(id, customerDTO);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName, updatedCustomer.getLastName());
        assertThat(originalLastName, not(equalTo(updatedCustomer.getLastName())));
        assertThat(originalFirstName, equalTo(updatedCustomer.getFirstName()));
    }

    private Long getCustomerIdValue() {
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers Found: " + customers.size());

        //return first id
        return customers.get(0).getId();
    }
}