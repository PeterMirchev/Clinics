package com.dent.model.entity;
import com.dent.model.enums.WardType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private Set<Doctor> doctors = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private WardType wardType;
    private boolean isDeleted;
}
