package ie.spring.adfProject.dtos;

import ie.spring.adfProject.entities.Household;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPet(@NotEmpty @NotNull
                     String name,
                     @NotEmpty @NotNull
                     String animalType,
                     @NotEmpty @NotNull
                     String breed,
                     @Min(value = 0, message = "Age must be greater than or equal to zero")
                     int age,
                     Household household
                     ) {
}
