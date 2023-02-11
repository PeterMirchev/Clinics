package com.dent.model.dto.expose;

import com.dent.model.enums.Role;
import com.dent.model.enums.UserType;
import lombok.Data;

import java.util.Set;

@Data
public class UserExposeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private UserType userType;
    private String phone;
    private Set<Role> role;
    private String email;
    private Integer age;
    private String address;
}
