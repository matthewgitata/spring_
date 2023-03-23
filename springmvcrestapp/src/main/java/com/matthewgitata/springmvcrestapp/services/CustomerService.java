package com.matthewgitata.springmvcrestapp.services;

import com.matthewgitata.springmvcrestapp.api.v1.model.CustomerDTO;

import java.util.List;

/**
 * created by @matthewgitata on 23/03/2023.
 */
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, final CustomerDTO customerDTO);

}