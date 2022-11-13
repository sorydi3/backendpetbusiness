package com.udacity.jdnd.course3.critter.employeeskill.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Repository
public interface EmployeeSkillRepository extends CrudRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployee(Employee employee);
}
