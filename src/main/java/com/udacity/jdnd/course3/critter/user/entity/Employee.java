package com.udacity.jdnd.course3.critter.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends User {
    @Column
    private String skills;
    @Column
    private String daysAvailable;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    List<Schedule> schedules;
}
