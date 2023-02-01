package com.dent.model.dto.seed;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class DoctorSeedDTO {
    @Size(min = 2)
    @NonNull
    private String firstName;
    @Size(min = 2)
    @NonNull
    private String lastName;
    @NonNull
    private String userType;
    private String phone;
    @Email
    private String email;
    @NonNull
    private String qualification;
    @NonNull
    private boolean onDuty;
}
