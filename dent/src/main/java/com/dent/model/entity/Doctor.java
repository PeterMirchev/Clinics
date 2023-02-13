package com.dent.model.entity;
import com.dent.model.enums.Qualification;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends User{
    @Enumerated(EnumType.STRING)
    private Qualification qualification;
    private boolean onDuty;


}
