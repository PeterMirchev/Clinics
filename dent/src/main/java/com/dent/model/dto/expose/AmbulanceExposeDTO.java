package com.dent.model.dto.expose;

import com.dent.model.entity.Clinic;
import lombok.Data;

@Data
public class AmbulanceExposeDTO {
    private Long id;
    private String vehicleName;
    private boolean vehicleAvailability;
    private Clinic clinic;
}
