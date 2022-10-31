package com.udacity.jdnd.course3.critter.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends User {
    @Column
    private String phoneNumber;
    @Column
    private String address;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<Schedule> schedules;
}