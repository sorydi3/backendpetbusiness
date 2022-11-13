package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.Utils;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.service.CustomerService;

import ch.qos.logback.classic.pattern.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    CustomerService customerService;

    @Autowired
    Utils utils;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Customer customer = customerService.getCustomerById(petDTO.getOwnerId());
        Pet pet = utils.convertPetDTOtoPet(petDTO);
        if (customer != null) {
            pet.setOwner(customer);
        }
        pet = petService.savePet(pet);
        return utils.convertPetToPetDTO(pet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petService.getPetById(petId);
        return utils.convertPetToPetDTO(pet);
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<PetDTO> petDTOs = new ArrayList<>();
        petService.getAllPets().forEach(pet -> {
            petDTOs.add(utils.convertPetToPetDTO(pet));
        });
        return petDTOs;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetDTO> petDTOs = new ArrayList<>();
        petService.getAllPetsByOwner(ownerId).forEach(pet -> {
            petDTOs.add(utils.convertPetToPetDTO(pet));
        });
        return petDTOs;
    }
}
