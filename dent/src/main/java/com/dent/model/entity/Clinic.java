package com.dent.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    @OneToMany
    private Set<Ambulance> ambulances = new HashSet<>();
    @OneToMany
    private Set<User> users = new HashSet<>();;
    @OneToMany
    private Set<Ward> wards = new HashSet<>();;
    @ManyToOne
    private City city;
    private boolean isDeleted;
}
