package com.udacity.jdnd.course3.critter.employeeskill.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;

@Repository
public interface EmployeeSkillRepository extends CrudRepository<EmployeeSkill, Long> {
}
