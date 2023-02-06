package com.dent.model.entity;
import com.dent.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.dent.model.enums.UserType;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Set<Role> role = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String phone;
    @Column(unique = true)
    private String email;
    private Integer age;
    private String address;
}
