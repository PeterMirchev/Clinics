package com.dent.model.dto.seed;

import com.dent.model.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
public class UserSeedDTO {
    @NonNull
    @Size(min = 2)
    private String firstName;
    @NonNull
    @Size(min = 2)
    private String lastName;
    @NonNull
    private UserType userType;
    private String phone;
    @Email
    private String email;
    @NonNull
    @Positive
    private Integer age;
    private String address;
}
