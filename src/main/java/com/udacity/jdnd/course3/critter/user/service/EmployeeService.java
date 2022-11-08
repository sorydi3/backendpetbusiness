package com.udacity.jdnd.course3.critter.user.service;

import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.Utils;
import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.employeeskill.service.EmployeeSkillService;
import com.udacity.jdnd.course3.critter.skill.entity.Skill;
import com.udacity.jdnd.course3.critter.skill.service.skillService;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.Skils;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    skillService skillService;

    @Autowired
    EmployeeSkillService employeeSkillService;

    @Autowired
    Utils utils;

    @Autowired
    private EmployeeRepository employeeRepository;

    // TODO: Add employee
    @Transactional
    public Employee saveEmployee(EmployeeDTO employee) {
        Employee savedEmpl = employeeRepository.save(utils.convertEmployeeDTOtoEmployee(employee));
        Set<Skils> skills = employee.getSkills();

        skills.forEach(skill -> {
            EmployeeSkill employeeSkill = new EmployeeSkill();
            Skill skillEntity = skillService.getSkillByName(skill);
            if (skillEntity == null) {
                skillEntity = skillService.saveSkill(new Skill(skill));
            }
            employeeSkill.setEmployee(savedEmpl);
            employeeSkill.setSkill(skillEntity);

            employeeSkillService.saveEmployeeSkill(employeeSkill);
        });
        System.out.println("Employee saved");
        System.out.println("SKILLS LIST ------>>>>>>>>>>>>>>>>>>>>>>>" + savedEmpl.getSkill());
        return savedEmpl;
    }

    // TODO: Get employee by id

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // TODO: Get employee by schedule

    // TODO: Get all employees

    // TODO: Get all employees by skill

    // TODO: get employee schedule
}
