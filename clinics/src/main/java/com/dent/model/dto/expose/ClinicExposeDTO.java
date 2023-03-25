package com.dent.model.dto.expose;

import com.dent.model.entity.Ambulance;
import com.dent.model.entity.City;
import com.dent.model.entity.User;
import com.dent.model.entity.Ward;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ClinicExposeDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Set<Ambulance> ambulances = new HashSet<>();
    private Set<User> users = new HashSet<>();
    private Set<Ward> wards;
    private City city;

}
