package ie.spring.adfProject.controllers.graphQL;

import ie.spring.adfProject.dtos.NewHousehold;
import ie.spring.adfProject.entities.Household;
import ie.spring.adfProject.entities.Pet;
import ie.spring.adfProject.repositories.records.Statistics;
import ie.spring.adfProject.services.HouseholdService;
import ie.spring.adfProject.services.PetService;
import ie.spring.adfProject.services.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLAPI {
    private final HouseholdService householdService;
    private final PetService petService;

    @QueryMapping
    List<Household> findAllHouseholds(){
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    List<Pet> findAllPetsByAnimalType(@Argument String animalType){
        return petService.getPetsByAnimalType(animalType);
    }

    @QueryMapping
    Household findHouseholdByEircode(@Argument String eircode) throws NotFoundException {
        return householdService.findByEircode(eircode);
    }

    @QueryMapping
    Pet findPetById(@Argument int id) throws NotFoundException {
        return petService.getPetById(id);
    }

    @QueryMapping
    List<Statistics> findAllStatistics(){
        return petService.findAllStatistics();
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
    @MutationMapping
    Household createHousehold(@Valid @RequestBody NewHousehold newHousehold) {
        return householdService.createHousehold(new Household(
                newHousehold.eircode(), newHousehold.numberOfOccupants(), newHousehold.maxNumberOfOccupants(), newHousehold.ownerOccupied()));
    }

    @Secured(value = "ROLE_ADMIN")
    @MutationMapping
    int deleteHousehold(@Argument String eircode) throws NotFoundException {
        householdService.deleteHouseholdByEircode(eircode);
        return 1;
    }

    @Secured(value = "ROLE_ADMIN")
    @MutationMapping
    int deletePet(@Argument int id) throws NotFoundException {
        petService.deletePetById(id);
        return 1;
    }
}
