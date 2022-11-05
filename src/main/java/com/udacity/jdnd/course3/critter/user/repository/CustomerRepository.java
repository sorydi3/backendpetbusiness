package com.udacity.jdnd.course3.critter.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.user.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // ADD CUSTOM QUERY METHODS HERE
}
