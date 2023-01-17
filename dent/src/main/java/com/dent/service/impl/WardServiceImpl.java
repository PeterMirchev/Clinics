package com.dent.service.impl;
import com.dent.model.dto.expose.WardExposeDTO;
import com.dent.model.dto.seed.WardSeedDTO;
import com.dent.service.WardService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WardServiceImpl implements WardService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Collection<WardExposeDTO> findAll() {
        return null;
    }

    @Override
    public WardExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public WardExposeDTO create(WardSeedDTO wardSeedDTO) {
        return null;
    }

    @Override
    public WardExposeDTO update(WardSeedDTO wardSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
