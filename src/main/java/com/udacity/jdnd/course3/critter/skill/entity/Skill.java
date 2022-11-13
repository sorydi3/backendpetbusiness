package com.udacity.jdnd.course3.critter.skill.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.udacity.jdnd.course3.critter.user.Skils;

import lombok.Data;

@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Skils skillName;

    // constructor with killName
    public Skill(Skils skillName) {
        this.skillName = skillName;
    }

    // constructor
    public Skill() {
    }

}