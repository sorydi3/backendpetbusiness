package com.udacity.jdnd.course3.critter.schedule.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

@Repository
public class ScheduleRepositoryJBDC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateScheduleCustomer(Long customerId, Long scheduleId) {
        int affected = jdbcTemplate.update("UPDATE scheduletable SET customer_id = ? WHERE id = ?", customerId,
                scheduleId);

    }
}
