package com.dent.model.dto.seed;
import jakarta.validation.constraints.Size;
import jdk.jfr.BooleanFlag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AmbulanceSeedDTO {
    @NonNull
    @Size(min = 2)
    private String vehicleName;
    @BooleanFlag
    private boolean vehicleAvailability;
}
