package com.dent.model.dto.expose;

import com.dent.model.enums.UserType;
import lombok.Data;

@Data
public class UserExposeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private UserType userType;
    private String phone;
    private String email;
    private Integer age;
    private String address;
}
