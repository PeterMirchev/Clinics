package com.dent.service.impl;

import com.dent.model.dto.expose.AmbulanceExposeDTO;
import com.dent.model.dto.seed.AmbulanceSeedDTO;
import com.dent.service.AmbulanceService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Collection<AmbulanceExposeDTO> findAll() {
        return null;
    }

    @Override
    public AmbulanceExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public AmbulanceExposeDTO create(AmbulanceSeedDTO ambulanceSeedDTO) {
        return null;
    }

    @Override
    public AmbulanceExposeDTO update(AmbulanceSeedDTO ambulanceSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
