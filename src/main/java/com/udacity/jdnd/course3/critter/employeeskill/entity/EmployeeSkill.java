package com.udacity.jdnd.course3.critter.employeeskill.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.skill.entity.Skill;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeskilltable")
@Getter
@Setter
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
    