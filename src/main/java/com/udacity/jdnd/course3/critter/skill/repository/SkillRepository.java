package com.udacity.jdnd.course3.critter.skill.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.skill.entity.Skill;
import com.udacity.jdnd.course3.critter.user.Skils;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

    // check if skill exists in database by name and return skill
    public List<Skill> findBySkillName(Skils skillName);

}
