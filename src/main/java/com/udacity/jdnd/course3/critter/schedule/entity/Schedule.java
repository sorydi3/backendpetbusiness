package com.udacity.jdnd.course3.critter.schedule.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "scheduletable")
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    LocalDateTime datee;

    private String activities;
    private String notes;

    // constructor
    public Schedule() {
        // TODO document why this constructor is empty
    }
}
