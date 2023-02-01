package com.dent.model.dto.seed;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class ClinicSeedDTO {
    @NonNull
    @Size(min = 2, max = 30)
    private String name;
    @NonNull
    @Size(min = 2, max = 30)
    private String address;
    @Email
    @NonNull
    private String email;
    @NonNull
    private String phone;
}
