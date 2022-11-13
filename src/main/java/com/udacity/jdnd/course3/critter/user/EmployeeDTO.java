package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;

import lombok.Data;

/**
 * Represents the form that employee request and response data takes. Does not
 * map
 * to the database directly.
 */
@Data
public class EmployeeDTO {
    private long id;
    private String name;
    private Set<Skils> skills;

    private Set<EmployeeSkill> skill;

    private Set<DayOfWeek> daysAvailable;

    public EmployeeDTO() {
    }

    public void initDaysAvailable() {
        daysAvailable = new HashSet<>();
    }

}
