package ie.spring.adfProject.services;

import ie.spring.adfProject.entities.Household;
import ie.spring.adfProject.repositories.HouseholdRepository;
import ie.spring.adfProject.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class HouseholdServiceImplementation implements HouseholdService {

    private HouseholdRepository householdRepository;

    @Override
    public Household findByEircode(String eircode) throws NotFoundException {
        return householdRepository.findByEircode(eircode).orElseThrow(
                ()-> new NotFoundException("Household not found with Eircode: " + eircode));
    }

    @Override
    public Household findByHouseholdEircode(String eircode) throws NotFoundException {
        return householdRepository.findHouseholdByEircode(eircode).orElseThrow(
                ()-> new NotFoundException("Household not found with Eircode: " + eircode));
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) throws NotFoundException {
        householdRepository.deleteByEircode(eircode);
    }

    @Override
    public List<Household> findAllWithNoPets() {
        return householdRepository.findAllByNumberOfOccupantsEquals(0);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household createHousehold(Household household){
        return householdRepository.save(household);
    }
}
