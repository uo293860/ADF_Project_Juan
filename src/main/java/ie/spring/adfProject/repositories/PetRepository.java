package ie.spring.adfProject.repositories;

import ie.spring.adfProject.entities.Pet;
import ie.spring.adfProject.repositories.records.NameTypeBreed;
import ie.spring.adfProject.repositories.records.Statistics;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PetRepository extends JpaRepository<Pet, Integer> {

    /*@Transactional
    @Modifying
    @Query("INSERT into pets")
    void addPet(String name, String animalType, String breed, int age);*/
    @Query("select p.name, p.animalType, p.breed, p.age from Pet p")
    List<Pet> findAllPets();

    Pet findPetById(int id);

    @Transactional
    @Modifying
    @Query("update Pet p set p.name=:newName, p.animalType=:newAnimalType, p.breed=:newBreed, p.age=:newAge where p.id=:id")
    int updatePetById(@Param("id") int id, @Param("newName") String newName, @Param("newAnimalType") String newAnimalType,
                      @Param("newBreed") String newBreed, @Param("newAge") int newAge);
    @Transactional
    @Modifying
    @Query("update Pet p set p.name=:newName where p.id=:id")
    int updatePetNameById(@Param("id") int id, @Param("newName") String newName);

    void deleteById(int id);

    void deleteByName(String name);

    List<Pet> findAllByAnimalType(String animalType);
    //List<Pet> findPetsByAnimalType(String animalType);

    @Query("select p.name, p.animalType, p.breed, p.age from Pet p where p.breed=:pBreed order by p.age asc")
    List<Pet> findAllByBreed(@Param("pBreed") String pBreed);

    @Query("select new ie.spring.adfProject.repositories.records.NameTypeBreed(p.name, p.animalType, p.breed) from Pet p")
    List<NameTypeBreed> findAllNameTypeBreed();

    @Query("select new ie.spring.adfProject.repositories.records.Statistics( avg(p.age), max(p.age)) from Pet p")
    List<Statistics> findAllStatistics();

}
