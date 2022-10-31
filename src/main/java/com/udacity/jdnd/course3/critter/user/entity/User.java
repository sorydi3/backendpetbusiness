package com.udacity.jdnd.course3.critter.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Nationalized;

import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@MappedSuperclass
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Nationalized
    private String notes;

}
