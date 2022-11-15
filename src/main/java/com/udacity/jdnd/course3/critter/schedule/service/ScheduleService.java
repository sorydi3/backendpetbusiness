package com.udacity.jdnd.course3.critter.schedule.service;

import java.time.DayOfWeek;
import java.util.List;

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
        if (day == null) {
            day = dayService.addDay(day_p);
        }
        Schedule schedule = new Schedule();
        schedule.setEmployee(employee);
        schedule.setDayOfWeek(day);
        return scheduleRepository.save(schedule);
    }

    public boolean isEmployeeAvailable(Employee employee, DayOfWeek day) {
        List<Schedule> schedules = scheduleRepository.findByEmployee(employee);

        for (Schedule schedule : schedules) {
            if (schedule.getDayOfWeek().getDayOfWeek().equals(day)) {
                return true;
            }
        }
        return false;
    }

    public List<Day> getAllSchedules() {
        return (List) dayService.getAllSchedules();
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedulesByEmployee(Employee employee) {
        return scheduleRepository.findByEmployee(employee);
    }

    public List<Schedule> getAllSchedulesByDay(DayOfWeek day) {
        return scheduleRepository.findByDayOfWeek(day);
    }

    public List<Schedule> getAllSchedulesByDay(Day day) {
        return scheduleRepository.findByDayOfWeek(day.getDayOfWeek());
    }

}
