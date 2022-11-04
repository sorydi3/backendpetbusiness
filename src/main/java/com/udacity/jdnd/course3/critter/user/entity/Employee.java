package com.udacity.jdnd.course3.critter.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employeetable")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String skills;

    @Column
    private String daysAvailable;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    List<Schedule> schedules;

    // constructor
    public Employee() {
        // TODO document why this constructor is empty
    }

}
