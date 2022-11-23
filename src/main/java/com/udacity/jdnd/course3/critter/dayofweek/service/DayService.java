package com.udacity.jdnd.course3.critter.dayofweek.service;

import java.time.DayOfWeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.dayofweek.entity.Day;
import com.udacity.jdnd.course3.critter.dayofweek.repository.DayRepository;

@Service
public class DayService {

    @Autowired
    DayRepository dayRepository;

    public Day addDay(DayOfWeek day) {
        return dayRepository.save(new Day(day));
    }

    public Day getDayById(Long id) {
        return dayRepository.findById(id).orElse(null);
    }

    public Day findByDayOfWeek(DayOfWeek day) {
        return dayRepository.findByDayOfWeek(day);
    }

    public Iterable<Day> getAllSchedules() {
        return dayRepository.findAll();
    }
}
