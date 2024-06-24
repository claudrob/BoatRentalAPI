package com.petscreening.BoatRentalAPI.repositories;

import com.petscreening.BoatRentalAPI.data.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findPetByName(String name);


    @Query("SELECT p FROM Pet p WHERE (:weight is null or p.weight <= :weight) and (:vaccinated is null or p.vaccinated = :vaccinated) and (:breed is null or p.breed != :breed) and (:trainingLevel is null or p.trainingLevel >= :trainingLevel)")
    Iterable<Pet> findByCriteria(@Param("weight") Double weight, @Param("vaccinated") Boolean vaccinated, @Param("breed") String breed, @Param("trainingLevel") Integer trainingLevel);

    @Query("SELECT p FROM Pet p WHERE p.weight <= :maxWeight")
    Iterable<Pet> findByMaxWeight(@Param("maxWeight") Double maxWeight);

    @Query("SELECT p FROM Pet p WHERE p.vaccinated = :vaccinated")
    Iterable<Pet> findByVaccinationStatus(@Param("vaccinated") Boolean vaccinated);

    @Query("SELECT p FROM Pet p WHERE p.breed != :excludedBreed")
    Iterable<Pet> findByExcludedBreed(@Param("excludedBreed") String excludedBreed);
}
