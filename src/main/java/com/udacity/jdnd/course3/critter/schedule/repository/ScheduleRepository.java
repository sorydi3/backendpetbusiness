package com.udacity.jdnd.course3.critter.schedule.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.dayofweek.entity.Day;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    List<Schedule> findByEmployee(Employee employee);

    List<Schedule> findByDayOfWeek(Day day);

    List<Schedule> findByCustomer(Customer customer);

}
