package com.udacity.jdnd.course3.critter.user.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.Utils;
import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.employeeskill.service.EmployeeSkillService;
import com.udacity.jdnd.course3.critter.schedule.ScheduleController;
import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;
import com.udacity.jdnd.course3.critter.skill.entity.Skill;
import com.udacity.jdnd.course3.critter.skill.service.SkillService;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.Skils;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    SkillService skillService;

    @Autowired
    ScheduleController scheduleController;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    EmployeeSkillService employeeSkillService;

    @Autowired
    EmployeeService employeeService;

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

        if (employee.getDaysAvailable() != null) {
            employee.getDaysAvailable().forEach(day -> {
                scheduleService.addScheduleDay(day, savedEmpl);
            });
        }
        return savedEmpl;
    }

    public void addEmployeeSkill(Long employeeId, List<Skils> skills) {

        for (Skils skills2 : skills) {
            EmployeeSkill employeeSkill = new EmployeeSkill();
            Skill skillEntity = skillService.getSkillByName(skills2);
            if (skillEntity == null) {
                skillEntity = skillService.saveSkill(new Skill(skills2));
            }
            employeeSkill.setEmployee(employeeService.getEmployeeById(employeeId));

            employeeSkill.setSkill(skillEntity);

            employeeSkillService.saveEmployeeSkill(employeeSkill);
        }
    }

    // TODO: Get employee by id

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findEmployeesForService(Set<Skils> skills, LocalDate date) {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeesForService = new ArrayList<>();

        employees.forEach(employee -> {
            Set<Skils> employeeSkills = employeeSkillService.getEmployeeSkills(employee);
            if (scheduleService.isEmployeeAvailable(employee, date.getDayOfWeek())
                    && employeeSkills.containsAll(skills)) {
                employeesForService.add(employee);
            }

        });
        return employeesForService;
    }

    // TODO: Get all employees

    // TODO: Get all employees by skill

    // TODO: get employee schedule

}
