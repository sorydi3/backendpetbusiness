package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.user.Skils;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not
 * map
 * to the database directly.
 */
@Data
public class ScheduleDTO {
    private long id;
    private List<Long> employeeIds;
    private List<Long> petIds;
    private LocalDate date;
    private Set<Skils> activities;
    Set<DayOfWeek> days;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Skils> getActivities() {
        return activities;
    }

    public void setActivities(Set<Skils> activities) {
        this.activities = activities;
    }
}
