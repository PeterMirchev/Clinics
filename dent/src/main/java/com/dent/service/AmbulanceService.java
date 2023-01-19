package com.dent.service;

import com.dent.model.dto.expose.AmbulanceExposeDTO;
import com.dent.model.dto.seed.AmbulanceSeedDTO;

import java.util.Collection;

public interface AmbulanceService {
    Long count();
    Collection<AmbulanceExposeDTO> findAll();
    AmbulanceExposeDTO findById(Long id);
    AmbulanceExposeDTO create(AmbulanceSeedDTO ambulanceSeedDTO);
    AmbulanceExposeDTO update(AmbulanceSeedDTO ambulanceSeedDTO, Long id);
    void deleteById(Long id);


}
