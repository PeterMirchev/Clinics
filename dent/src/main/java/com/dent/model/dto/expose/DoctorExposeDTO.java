package com.dent.model.dto.expose;
import lombok.Data;

@Data
public class DoctorExposeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String userType;
    private String phone;
    private String email;
    private String qualification;
    private boolean onDuty;
}
