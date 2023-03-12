package com.dent.model.entity;
import com.dent.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.dent.model.enums.UserType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class)
    private Set<Role> role = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String phone;
    @Column(unique = true)
    private String email;
    private Integer age;
    private String address;
    private Date dateRegistered = new Date();
    private boolean isDeleted;
}
