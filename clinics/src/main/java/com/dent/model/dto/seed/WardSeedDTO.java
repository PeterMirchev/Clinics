package com.dent.model.dto.seed;

import com.dent.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardSeedDTO {
    private Set<User> users = new HashSet<>();
    @NotNull
    @Size(min = 2)
    private String wardType;
}
