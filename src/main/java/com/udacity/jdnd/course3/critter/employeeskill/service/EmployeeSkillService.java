package com.udacity.jdnd.course3.critter.employeeskill.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.employeeskill.repository.EmployeeSkillRepository;
import com.udacity.jdnd.course3.critter.skill.service.SkillService;
import com.udacity.jdnd.course3.critter.user.Skils;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Service
public class EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;

    @Autowired
    SkillService skilService;

    // TODO: Add employee skill
    public EmployeeSkill saveEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    public Set<Skils> getEmployeeSkills(Employee employee) {
        List<EmployeeSkill> skills = employeeSkillRepository.findByEmployee(employee);
        Set<Skils> skils = new HashSet<>();
        skills.forEach(skill -> skils.add(skill.getSkill().getSkillName()));
        return skils;
    }
}
