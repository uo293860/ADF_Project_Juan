package ie.spring.adfProject.controllers.rest;

import ie.spring.adfProject.dtos.NewHousehold;
import ie.spring.adfProject.dtos.NewPet;
import ie.spring.adfProject.entities.Household;
import ie.spring.adfProject.entities.Pet;
import ie.spring.adfProject.services.HouseholdService;
import ie.spring.adfProject.services.exceptions.BadDataException;
import ie.spring.adfProject.services.exceptions.NotFoundException;
import ie.spring.adfProject.services.PetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class HouseholdWebService {
    private final HouseholdService householdService;
    private final PetService petService;

    @GetMapping({"/pets"})
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    // Get a pet by ID
    @GetMapping("/pets/{id}")
    public Pet getPet(@PathVariable int id) {
        return petService.getPetById(id);
    }

    // Create a new pet
    @PostMapping({"/pets"})
    @ResponseStatus(HttpStatus.CREATED)
    public Pet createPet(@Valid @RequestBody NewPet newPet) throws BadDataException {
        Pet pet= new Pet(newPet.name(), newPet.animalType(), newPet.breed(), newPet.age(), newPet.household());
        return petService.createPet(pet);
    }

    // Update a pet's name
    @PatchMapping("/pets/{id}")
    public int updatePetName(@PathVariable int id, @RequestBody String name) {
        return petService.updatePetNameById(id, name);
    }

    // Delete a pet
    @DeleteMapping("/pets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable int id) {
        petService.deletePetById(id);
    }

    @GetMapping("/households")
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/households/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.findAllWithNoPets();
    }

    @GetMapping("/households/{eircode}")
    public Household getHousehold(@PathVariable String eircode) throws NotFoundException {
        return householdService.findByEircode(eircode);
    }

    @PostMapping("/households")
    @ResponseStatus(HttpStatus.CREATED)
    public Household createHousehold(@Valid @RequestBody NewHousehold newHousehold) {
        return householdService.createHousehold(new Household(
                newHousehold.eircode(), newHousehold.numberOfOccupants(), newHousehold.maxNumberOfOccupants(), newHousehold.ownerOccupied()));
    }

    @DeleteMapping("/households/{eircode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHousehold(@PathVariable String eircode) throws NotFoundException {
        householdService.deleteHouseholdByEircode(eircode);
    }
}
