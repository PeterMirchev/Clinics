package com.dent.model.dto.expose;

import com.dent.model.entity.Clinic;
import lombok.Data;

import java.util.List;

@Data
public class CityExposeDTO {
    private Long id;
    private String name;
    private List<Clinic> clinics;
}
