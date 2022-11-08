package com.udacity.jdnd.course3.critter.dayofweek.repository;

import java.time.DayOfWeek;

import org.springframework.data.repository.CrudRepository;

import com.udacity.jdnd.course3.critter.dayofweek.entity.Day;

public interface DayRepository extends CrudRepository<Day, Long> {

    Day findByDayOfWeek(DayOfWeek day);
}
    