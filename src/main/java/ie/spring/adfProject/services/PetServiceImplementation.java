package ie.spring.adfProject.services;

import ie.spring.adfProject.entities.Pet;
import ie.spring.adfProject.repositories.PetRepository;
import ie.spring.adfProject.repositories.records.NameTypeBreed;
import ie.spring.adfProject.repositories.records.Statistics;
import ie.spring.adfProject.services.exceptions.BadDataException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class PetServiceImplementation implements PetService {

    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(int id) {
        return petRepository.findPetById(id);
    }

    @Override
    public int updatePetById(int id, String name, String type, String breed, int age) {
        return petRepository.updatePetById(id, name, type, breed, age);
    }

    @Override
    public int updatePetNameById(int id, String name) {
        return petRepository.updatePetNameById(id, name);
    }

    @Override
    public void deletePetById(int id) {
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetByName(String name) {
        petRepository.deleteByName(name);
    }

    @Override
    public List<Pet> getPetsByAnimalType(String animalType) {
        return petRepository.findAllByAnimalType(animalType);
    }

    @Override
    public List<Pet> findAllByBreed(String breed) {
        return petRepository.findAllByBreed(breed);
    }

    @Override
    public List<NameTypeBreed> findAllNameTypeBreed() {
        return petRepository.findAllNameTypeBreed();
    }

    @Override
    public List<Statistics> findAllStatistics() {
        return petRepository.findAllStatistics();
    }

    @Override
    public Pet createPet(Pet pet) throws BadDataException {
        if (pet.getName().isBlank()){
            throw new BadDataException("Check the name of the pet.");
        }
        if (pet.getAnimalType().isBlank()){
            throw new BadDataException("Check the animal type of the pet.");
        }
        if (pet.getBreed().isBlank()){
            throw new BadDataException("Check the breed of the pet.");
        }
        if (pet.getAge()<0){
            throw new BadDataException("The age of the pet must be higher or equal to zero.");
        }
        return petRepository.save(pet);

    }
}
