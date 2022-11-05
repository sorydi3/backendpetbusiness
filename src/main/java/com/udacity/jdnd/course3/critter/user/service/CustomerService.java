package com.udacity.jdnd.course3.critter.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // TODO Save customer

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // TODO Get customer

    // TODO Get customer/owner by pet

    // TODO Get customer by schedule

    // TODO Get all customers

    // TODO Delete customer

    // TODO Delete customer by pet

    // TODO Delete customer by schedule

    // TODO Delete all customers

    // TODO get all customer pets

}
