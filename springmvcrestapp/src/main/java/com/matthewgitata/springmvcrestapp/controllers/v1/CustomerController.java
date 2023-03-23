package com.matthewgitata.springmvcrestapp.controllers.v1;

import com.matthewgitata.springmvcrestapp.api.v1.model.CustomerDTO;
import com.matthewgitata.springmvcrestapp.api.v1.model.CustomerListDTO;
import com.matthewgitata.springmvcrestapp.domain.Customer;
import com.matthewgitata.springmvcrestapp.services.CustomerService;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getListOfCustomers() {
        return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getAllCustomers()),
                HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomeDTO>(customerService.createNewCustomer(customerDTO),
                HttpStatus.CREATED);
    }
}