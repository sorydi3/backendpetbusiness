package com.udacity.jdnd.course3.critter.schedule.repository;

import java.time.DayOfWeek;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    Schedule findByDayOfWeek(DayOfWeek day);
}
