package com.udacity.jdnd.course3.critter.employeeskill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.employeeskill.repository.EmployeeSkillRepository;

@Service
public class EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;

    // TODO: Add employee skill
    public EmployeeSkill saveEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }
}
