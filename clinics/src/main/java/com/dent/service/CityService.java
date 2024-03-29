package com.dent.service;

import com.dent.model.dto.expose.CityExposeDTO;
import com.dent.model.dto.seed.CitySeedDTO;

import java.util.Collection;

public interface CityService {
    long count();
    Collection<CityExposeDTO> findAll();
    CityExposeDTO findById(Long id);
    CityExposeDTO create(CitySeedDTO citySeedDTO);
    CityExposeDTO update(CitySeedDTO citySeedDTO, Long id);
    public CityExposeDTO addClinic(Long cityId, Long clinicId);
    public CityExposeDTO removeClinic(Long cityId, Long clinicId);
    void deleteById(Long id);
}
