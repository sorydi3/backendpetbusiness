package com.udacity.jdnd.course3.critter.user.entity;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.hibernate.annotations.Nationalized;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import javax.persistence.GeneratedValue;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Nationalized
    private String notes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_schedule", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"))
    List<Schedule> schedules;

}
