package com.matthewgitata.springmvcrestapp.repositories;

import com.matthewgitata.springmvcrestapp.domain.Customer;

/**
 * created by @matthewgitata on 23/03/2023.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}