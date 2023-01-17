package com.dent.service;

import com.dent.model.dto.expose.WardExposeDTO;
import com.dent.model.dto.seed.WardSeedDTO;

import java.util.Collection;

public interface WardService {
    Integer count();
    Collection<WardExposeDTO> findAll();
    WardExposeDTO findById(Long id);
    WardExposeDTO create(WardSeedDTO wardSeedDTO);
    WardExposeDTO update(WardSeedDTO wardSeedDTO, Long id);
    void deleteById(Long id);
}
