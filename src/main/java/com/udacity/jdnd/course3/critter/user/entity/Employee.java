package com.udacity.jdnd.course3.critter.user.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@Table(name = "employeetable")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    @Nationalized
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    Set<Schedule> schedules;

    // constructor
    public Employee() {
        // TODO document why this constructor is empty
    }

}
