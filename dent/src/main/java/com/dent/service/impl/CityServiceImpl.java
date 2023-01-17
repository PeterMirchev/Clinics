package com.dent.service.impl;
import com.dent.model.dto.expose.CityExposeDTO;
import com.dent.model.dto.seed.CitySeedDTO;
import com.dent.service.CityService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityServiceImpl implements CityService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Collection<CityExposeDTO> findAll() {
        return null;
    }

    @Override
    public CityExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public CityExposeDTO create(CitySeedDTO citySeedDTO) {
        return null;
    }

    @Override
    public CityExposeDTO update(CitySeedDTO citySeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
