package com.dent.service.impl;

import com.dent.model.dto.expose.ClinicExposeDTO;
import com.dent.model.dto.seed.ClinicSeedDTO;
import com.dent.service.ClinicService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Collection<ClinicExposeDTO> findAll() {
        return null;
    }

    @Override
    public ClinicExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public ClinicExposeDTO create(ClinicSeedDTO clinicSeedDTO) {
        return null;
    }

    @Override
    public ClinicExposeDTO update(ClinicSeedDTO clinicSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
