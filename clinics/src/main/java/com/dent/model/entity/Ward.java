package com.dent.model.entity;
import com.dent.model.enums.WardType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private WardType wardType;
    @OneToMany
    private List<User> users = new ArrayList<>();
    private boolean isDeleted;
}
