package com.dent.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @OneToMany
    private Set<Ambulance> ambulances;
    @OneToMany
    private Set<User> users;
    @OneToMany
    private Set<Ward> wards;
    @ManyToOne
    private City city;
}
