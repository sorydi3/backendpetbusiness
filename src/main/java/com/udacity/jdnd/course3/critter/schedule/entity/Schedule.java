package com.udacity.jdnd.course3.critter.schedule.entity;

import javax.persistence.Entity;

import java.util.List;
import javax.persistence.Id;

import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.repository.CusomerRepository;

import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;
    private Employee employee;
    private Customer customer;
    private String activities;
    private String date;
    private String notes;
}
