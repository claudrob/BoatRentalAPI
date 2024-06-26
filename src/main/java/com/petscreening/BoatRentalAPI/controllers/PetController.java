package com.petscreening.BoatRentalAPI.controllers;

import com.petscreening.BoatRentalAPI.data.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.petscreening.BoatRentalAPI.repositories.PetRepository;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;


@Controller
public class PetController {

    private final PetRepository petRepository;

    @Autowired
    private Validator validator;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @QueryMapping
    public Iterable<Pet> pets(){
        return this.petRepository.findAll();
    }

    @QueryMapping
    public Pet petById(@Argument Long id){
        return this.petRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Pet petByName(@Argument String name){
        return this.petRepository.findPetByName(name);
    }

    @QueryMapping
    public Iterable<Pet> petsByMaxWeight(@Argument Double maxWeight){
        return this.petRepository.findByMaxWeight(maxWeight);
    }

    @QueryMapping
    public Iterable<Pet> eligiblePets(@Argument Double weight, @Argument Boolean vaccinated, @Argument String breed, @Argument Integer trainingLevel){
        return this.petRepository.findByCriteria(weight, vaccinated, breed, trainingLevel);
    }

    @QueryMapping
    public Iterable<Pet> petsByVaccinationStatus(@Argument Boolean vaccinated){
        return this.petRepository.findByVaccinationStatus(vaccinated);
    }

    @QueryMapping
    public Iterable<Pet> petsByExcludedBreed(@Argument String excludedBreed){
        return this.petRepository.findByExcludedBreed(excludedBreed);
    }

    @MutationMapping
    public Pet addPet(@Argument(name="input") PetInput petInput){
        Pet pet = petInput.getPetEntity();

        // Validate the Pet object
        Set<ConstraintViolation<Pet>> violations = validator.validate(pet);
        if (!violations.isEmpty()) {
            // Handle validation errors
            throw new ConstraintViolationException(violations);
        }
        return this.petRepository.save(pet);
    }

    @MutationMapping
    public boolean deletePet(@Argument Long id){
        try {
            this.petRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @MutationMapping
    public Pet updatePet(@Argument Long id, @Argument("pet") PetInput petInput){
    Pet pet = this.petRepository.findById(id).orElseThrow();
    Pet updatedPet = petInput.getPetEntity();
    updatedPet.setId(pet.getId());

    // Validate the Pet object
        Set<ConstraintViolation<Pet>> violations = validator.validate(updatedPet);
        if (!violations.isEmpty()) {
            // Handle validation errors
            throw new ConstraintViolationException(violations);
        }
    return this.petRepository.save(updatedPet);
}

}
