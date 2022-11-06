package com.udacity.jdnd.course3.critter.pet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.entity.Customer;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findByOwner(Customer owner);

}
