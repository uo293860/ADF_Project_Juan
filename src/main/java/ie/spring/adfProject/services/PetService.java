package ie.spring.adfProject.services;

import ie.spring.adfProject.entities.Household;
import ie.spring.adfProject.entities.Pet;
import ie.spring.adfProject.repositories.records.NameTypeBreed;
import ie.spring.adfProject.repositories.records.Statistics;
import ie.spring.adfProject.services.exceptions.BadDataException;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();
    Pet getPetById(int id);
    int updatePetById(int id, String name, String type, String breed, int age);
    int updatePetNameById(int id, String name);
    void deletePetById(int id);
    void deletePetByName(String name);
    List<Pet> getPetsByAnimalType(String animalType);
    List<Pet> findAllByBreed(String breed);
    List<NameTypeBreed> findAllNameTypeBreed();
    List<Statistics> findAllStatistics();

    Pet createPet(Pet pet) throws BadDataException;
}
