package com.dent.service;

import com.dent.model.dto.expose.ClinicExposeDTO;
import com.dent.model.dto.seed.ClinicSeedDTO;

import java.util.Collection;

public interface ClinicService {
    Integer count();
    Collection<ClinicExposeDTO> findAll();
    ClinicExposeDTO findById(Long id);
    ClinicExposeDTO create(ClinicSeedDTO clinicSeedDTO);
    ClinicExposeDTO update(ClinicSeedDTO clinicSeedDTO, Long id);
    void deleteById(Long id);
}
