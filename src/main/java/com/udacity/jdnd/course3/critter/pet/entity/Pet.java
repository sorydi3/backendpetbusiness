package com.udacity.jdnd.course3.critter.pet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.PetType;
import com.udacity.jdnd.course3.critter.user.entity.User;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private PetType type;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
