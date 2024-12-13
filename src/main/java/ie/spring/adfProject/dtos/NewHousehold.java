package ie.spring.adfProject.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewHousehold(@NotBlank(message = "Eircode is required") String eircode,
                           int numberOfOccupants,
                           @Min(value = 1, message = "Maximum number of occupants must be at least 1")
                           int maxNumberOfOccupants,
                           @NotNull(message = "Owner-occupied status must be specified") boolean ownerOccupied) {
}
