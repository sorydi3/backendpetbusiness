package com.udacity.jdnd.course3.critter.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.user.entity.*;

@Repository
public interface CusomerRepository extends CrudRepository<Employee, Long> {

}
