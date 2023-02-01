package com.dent.model.entity;
import com.dent.model.enums.Qualification;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Doctor extends User{
    @Enumerated(EnumType.STRING)
    private Qualification qualification;
    private boolean onDuty;


}
