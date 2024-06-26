package com.petscreening.BoatRentalAPI.data;

import jakarta.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "PET")
public class Pet {

    @Id
    @Column(name = "PET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PET_NAME")
    private String name;
    @Column(name = "PET_TYPE")
    private String type;
    @Column(name = "PET_BREED")
    private String breed;
    @Column(name = "WEIGHT")
    private double weight;
    @Column(name = "VACCINATED")
    private Boolean vaccinated;

    @Column(name = "TRAINING_LEVEL")
    @Min(1)
    @Max(10)
    private int trainingLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
    public Boolean getVaccinated() {
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
}
