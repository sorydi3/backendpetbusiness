package com.udacity.jdnd.course3.critter.schedule.service;

import java.time.DayOfWeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.dayofweek.entity.Day;
import com.udacity.jdnd.course3.critter.dayofweek.service.DayService;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    DayService dayService;

    public Schedule addScheduleDay(DayOfWeek day_p, Employee employee) {

        Day day = dayService.findByDayOfWeek(day_p);
        // dayOfWeek

        Schedule schedule = new Schedule();
        // schedule.setDayOfWeek(day);
        schedule.setEmployee(employee);
        schedule.setDayOfWeek(day);

        return scheduleRepository.save(schedule);
    }

}
