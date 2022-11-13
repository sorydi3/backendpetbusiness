package com.udacity.jdnd.course3.critter.skill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.skill.entity.Skill;
import com.udacity.jdnd.course3.critter.skill.repository.SkillRepository;
import com.udacity.jdnd.course3.critter.user.Skils;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    // save skill
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // check if skill exists in database by name and return skill
    public Skill getSkillByName(Skils name) {
        return skillRepository.findBySkillName(name).stream().findFirst().orElse(null);
    }

    // get skill by id
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
