package com.udacity.jdnd.course3.critter.schedule.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleRepositoryJBDC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateScheduleCustomer(Long customerId, Long scheduleId) {
        jdbcTemplate.update("UPDATE scheduletable SET customer_id = ? WHERE id = ?", customerId, scheduleId);
    }
}
