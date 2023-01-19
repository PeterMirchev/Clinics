package com.dent.model.dto.seed;

import com.dent.model.entity.Clinic;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
@Data
@NoArgsConstructor
public class CitySeedDTO {
    @Size(min = 2)
    @NonNull
    private String name;
    @NonNull
    private List<Clinic> clinics;
}
