package com.udacity.jdnd.course3.critter.employeeskill.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.skill.entity.Skill;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

import lombok.Data;

@Entity
@Table(name = "employeeskilltable")
@Data
public class EmployeeSkill {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public EmployeeSkill() {
        // TODO this constructor is required by JPA
    }
}
