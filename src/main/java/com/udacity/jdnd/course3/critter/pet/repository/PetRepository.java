package com.udacity.jdnd.course3.critter.pet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

}
