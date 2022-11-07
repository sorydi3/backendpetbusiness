package com.udacity.jdnd.course3.critter.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.service.CustomerService;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerService customerService;

    // TODO: Add pet
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    // get all pets

    public Iterable<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // get pet by id

    public Pet  getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    // get all pets by owner
    public List<Pet> getAllPetsByOwner(Long ownerId) {
        return petRepository.findByOwner(customerService.getCustomerById(ownerId));
    }
}
