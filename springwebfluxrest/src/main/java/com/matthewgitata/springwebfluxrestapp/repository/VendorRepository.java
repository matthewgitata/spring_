package com.matthewgitata.springwebfluxrestapp.repository;

import com.matthewgitata.springwebfluxrestapp.domain.Vendor;

/**
 * created by @matthewgitata on 24/03/2023.
 */
public interface VendorRepository extends ReactiveMongoRepository<Vendor, String>{
}