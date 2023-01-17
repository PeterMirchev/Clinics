package com.dent.service.impl;

import com.dent.model.dto.expose.PatientExposeDTO;
import com.dent.model.dto.seed.PatientSeedDTO;
import com.dent.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PatientServiceImpl implements PatientService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Collection<PatientExposeDTO> findAll() {
        return null;
    }

    @Override
    public PatientExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public PatientExposeDTO create(PatientSeedDTO patientSeedDTO) {
        return null;
    }

    @Override
    public PatientExposeDTO update(PatientSeedDTO patientSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
