package ie.spring.adfProject.services;

import ie.spring.adfProject.entities.Household;
import ie.spring.adfProject.services.exceptions.NotFoundException;

import java.util.List;

public interface HouseholdService {

    Household findByEircode(String eircode) throws NotFoundException;

    void deleteHouseholdByEircode(String eircode) throws NotFoundException;

    Household findByHouseholdEircode(String eircode) throws NotFoundException;

    List<Household> findAllWithNoPets();

    List<Household> getAllHouseholds();

    Household createHousehold(Household household);
}
