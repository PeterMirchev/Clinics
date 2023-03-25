package com.dent.model.dto.seed;

import com.dent.model.enums.UserType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserSeedDTO {
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 2)
    private String lastName;
    @NotNull
    private String password;
    @NotNull
    private UserType userType;
    private String phone;
    @Email
    @NotNull
    private String email;
    @NotNull
    @Positive
    private Integer age;
    private String address;
}
