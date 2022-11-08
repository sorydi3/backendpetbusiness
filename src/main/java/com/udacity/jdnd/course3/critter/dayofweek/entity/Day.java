package com.udacity.jdnd.course3.critter.dayofweek.entity;

import java.time.DayOfWeek;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import lombok.Data;

@Entity
@Data
public class Day {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @OneToMany(mappedBy = "dayOfWeek")
    private List<Schedule> schedule;

    // constructor
    public Day(DayOfWeek dayOfWeek) {
        // TODO document why this constructor is empty
        this.dayOfWeek = dayOfWeek;
    }

    // constructor
    public Day() {
        // TODO document why this constructor is empty
    }

}
