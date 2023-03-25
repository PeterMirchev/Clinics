package com.dent.model.dto.seed;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class ClinicSeedDTO {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 2, max = 30)
    private String address;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String phone;
}
