package com.matthewgitata.springmvcrestapp.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {
    List<CustomerDTO> customers;
}