package com.udacity.jdnd.course3.critter.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // TODO: Add custom query methods here.
}
