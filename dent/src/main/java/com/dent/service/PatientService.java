package com.dent.service;

import com.dent.model.dto.expose.PatientExposeDTO;
import com.dent.model.dto.seed.PatientSeedDTO;

import java.util.Collection;

public interface PatientService {
    Integer count();
    Collection<PatientExposeDTO> findAll();
    PatientExposeDTO findById(Long id);
    PatientExposeDTO create(PatientSeedDTO patientSeedDTO);
    PatientExposeDTO update(PatientSeedDTO patientSeedDTO, Long id);
    void deleteById(Long id);
}
