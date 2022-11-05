package com.udacity.jdnd.course3.critter.employeeskill;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.skill.Skill;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Entity
@Table(name = "employeeskilltable")
public class EmployeeSkill {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public EmployeeSkill() {
    }
}
