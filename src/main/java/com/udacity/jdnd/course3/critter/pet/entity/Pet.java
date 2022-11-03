package com.udacity.jdnd.course3.critter.pet.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.PetType;
import com.udacity.jdnd.course3.critter.user.entity.Customer;

@Entity
@Table(name = "petTable")
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String notes;

    @ManyToOne
    private Customer owner;

    public Pet() {
    }
}
