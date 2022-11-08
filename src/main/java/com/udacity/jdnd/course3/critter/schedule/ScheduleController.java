package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.Utils;
import com.udacity.jdnd.course3.critter.dayofweek.service.DayService;
import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;

import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private Utils utils;

    @Autowired
    DayService dayService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        System.out.println("ScheduleController.createSchedule()" + scheduleDTO.getDays());
        scheduleDTO.getDays().forEach(day -> {
            dayService.addDay(day);
        });
        return null;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        throw new UnsupportedOperationException();
    }
}
