package com.udacity.jdnd.course3.critter.schedule.service;

import java.io.Console;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.dayofweek.entity.Day;
import com.udacity.jdnd.course3.critter.dayofweek.service.DayService;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepositoryJBDC;
import com.udacity.jdnd.course3.critter.user.Skils;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.service.EmployeeService;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleRepositoryJBDC scheduleRepositoryJBDC;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DayService dayService;

    @Autowired
    private PetService petService;

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

    public Iterable<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void createSchedule(ScheduleDTO scheduleDTO) {
        List<Long> employeeIds = scheduleDTO.getEmployeeIds();
        List<Long> petIds = scheduleDTO.getPetIds();
        Set<Skils> days = scheduleDTO.getActivities();
        
        String dayOfWeek = scheduleDTO.getDate().getDayOfWeek().toString();
        employeeIds.forEach(employeeId -> {
            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee != null && isEmployeeAvailable(employee, scheduleDTO.getDate().getDayOfWeek())) {
                Day day = dayService.findByDayOfWeek(DayOfWeek.valueOf(dayOfWeek));
                getAllSchedulesByDay(day).forEach(schedule -> {
                    if (schedule.getEmployee().getId().equals(employeeId)
                            && isEmployeeAvailable(employee, scheduleDTO.getDate().getDayOfWeek())) {
                        scheduleRepositoryJBDC.updateScheduleCustomer(
                                petService.getPetById(petIds.get(0)).getOwner().getId(), schedule.getId());

                    }

                });
            }
        });

    }

    public List<Schedule> getAllSchedulesByEmployee(Employee employee) {
        return scheduleRepository.findByEmployee(employee);
    }

    public List<Schedule> getAllSchedulesByDay(Day day) {
        System.out.println("day: " + day);
        scheduleRepository.findByDayOfWeek(day);
        return scheduleRepository.findByDayOfWeek(day);
    }

    public List<Pet> getAllSchedulesByPet(Long EmployeeId) {
        // Iterable<Schedule> schedules = scheduleRepository.findAll();
        return null;
    }

}
