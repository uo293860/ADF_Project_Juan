package ie.spring.adfProject.repositories;

import ie.spring.adfProject.entities.Household;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface HouseholdRepository extends JpaRepository<Household, Integer> {

    List<Household> findAll();

    Optional<Household> findByEircode(String eircode);

    @Transactional
    @Modifying
    void deleteByEircode(String eircode);

    // This method also loads the list of pets
    @EntityGraph(attributePaths = {"pets"})
    Optional<Household> findHouseholdByEircode(String eircode);

    List<Household> findAllByNumberOfOccupantsEquals(int numberOfOccupants);

}
