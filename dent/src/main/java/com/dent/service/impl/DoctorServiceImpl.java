package com.dent.service.impl;

import com.dent.model.dto.expose.DoctorExposeDTO;
import com.dent.model.dto.seed.DoctorSeedDTO;
import com.dent.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Collection<DoctorExposeDTO> findAll() {
        return null;
    }

    @Override
    public DoctorExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public DoctorExposeDTO create(DoctorSeedDTO doctorSeedDTO) {
        return null;
    }

    @Override
    public DoctorExposeDTO update(DoctorSeedDTO doctorSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
