package ie.spring.adfProject.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String animalType;
    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name="household_eircode")
    Household household;

    public Pet(String name, String animalType, String breed, int age, Household household){
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.household = household;
    }
}
