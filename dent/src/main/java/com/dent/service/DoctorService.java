package com.dent.service;

import com.dent.model.dto.expose.DoctorExposeDTO;
import com.dent.model.dto.seed.DoctorSeedDTO;

import java.util.Collection;

public interface DoctorService {
    Long count();
    Collection<DoctorExposeDTO> findAll();
    DoctorExposeDTO findById(Long id);
    DoctorExposeDTO create(DoctorSeedDTO doctorSeedDTO);
    DoctorExposeDTO update(DoctorSeedDTO doctorSeedDTO, Long id);
    void deleteById(Long id);
}
