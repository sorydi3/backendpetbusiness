package com.udacity.jdnd.course3.critter.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    PetService petService;

    // TODO Save customer

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // TODO Get customer by id

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // TODO Get customer/owner by pet

    // TODO Get customer by schedule

    // TODO Get all customers
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // TODO Delete customer

    // TODO Delete customer by pet

    // TODO Delete customer by schedule

    // TODO Delete all customers

    // TODO get all customer pets

    // TODO get owner by pet
    public Customer getOwnerByPet(Long petId) {
        Pet pet = petService.getPetById(petId);
        if (pet != null) {
            return pet.getOwner();
        }
        return null;
    }

}
