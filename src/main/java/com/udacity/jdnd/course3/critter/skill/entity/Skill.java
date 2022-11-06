package com.udacity.jdnd.course3.critter.skill.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.udacity.jdnd.course3.critter.employeeskill.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.Skils;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Skils skillName;

    @OneToMany(mappedBy = "skill")
    private List<EmployeeSkill> employee;

    // constructor with killName
    public Skill(Skils skillName) {
        this.skillName = skillName;
    }

}