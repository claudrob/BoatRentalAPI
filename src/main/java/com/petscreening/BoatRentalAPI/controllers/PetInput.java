package com.petscreening.BoatRentalAPI.controllers;

import com.petscreening.BoatRentalAPI.data.Pet;
import jakarta.persistence.Column;

public class PetInput {

    private String name;
    private String type;
    private String breed;
    private double weight;
    private Boolean vaccinated;
    private int trainingLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public int getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(int trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public Pet getPetEntity() {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setType(type);
        pet.setBreed(breed);
        pet.setWeight(weight);
        pet.setVaccinated(vaccinated);
        pet.setTrainingLevel(trainingLevel);
        return pet;
    }
}
