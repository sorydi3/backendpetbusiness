package com.udacity.jdnd.course3.critter.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String phoneNumber;
    @Column
    private String address;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    List<Pet> pets;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<Schedule> schedules;

    // constructor
    public Customer() {
    }
}