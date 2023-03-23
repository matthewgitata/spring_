package com.matthewgitata.springmvcrestapp.bootstrap;

import com.matthewgitata.springmvcrestapp.domain.Category;
import com.matthewgitata.springmvcrestapp.domain.Customer;
import com.matthewgitata.springmvcrestapp.domain.Vendor;
import com.matthewgitata.springmvcrestapp.repositories.CategoryRepository;
import com.matthewgitata.springmvcrestapp.repositories.CustomerRepository;
import com.matthewgitata.springmvcrestapp.repositories.VendorRepository;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        loadCustomers();

        loadCategories();

        loadVendors();
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count());
    }

    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer1.setId(2L);
        customer1.setFirstName("Sam");
        customer1.setLastName("Axe");
        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + categoryRepository.count());
    }

    private void loadVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor 1");
        vendorRepository.save(vendor1);

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor 2");
        vendorRepository.save(vendor2);
    }
}