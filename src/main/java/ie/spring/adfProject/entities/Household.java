package ie.spring.adfProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "households")
@AllArgsConstructor
@NoArgsConstructor
public class Household {
    @Id
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pet> pets;

    public Household(String eircode, int numberOfOccupants, int maxNumberOfOccupants, boolean ownerOccupied){
        this.eircode = eircode;
        this.numberOfOccupants = numberOfOccupants;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
        this.ownerOccupied = ownerOccupied;
    }
}
