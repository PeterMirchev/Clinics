package com.dent.service.impl;

import com.dent.exception.ExceptionMessages;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.AmbulanceExposeDTO;
import com.dent.model.dto.seed.AmbulanceSeedDTO;
import com.dent.model.entity.Ambulance;
import com.dent.repository.AmbulanceRepository;
import com.dent.service.AmbulanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {
    private final AmbulanceRepository ambulanceRepository;
    private final ModelMapper modelMapper;

    public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository, ModelMapper modelMapper) {
        this.ambulanceRepository = ambulanceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long count() {
        return ambulanceRepository.count();
    }

    @Override
    public Collection<AmbulanceExposeDTO> findAll() {
        return ambulanceRepository.findAll()
                .stream()
                .map(dto -> modelMapper.map(dto, AmbulanceExposeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AmbulanceExposeDTO findById(Long id) {
        return ambulanceRepository.findById(id)
                .map(dto ->modelMapper.map(dto, AmbulanceExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.AMBULANCE_DOES_NOT_EXIST, id)));

    }

    @Override
    public AmbulanceExposeDTO create(AmbulanceSeedDTO ambulanceSeedDTO) {
        Ambulance ambulance = ambulanceRepository.save(modelMapper.map(ambulanceSeedDTO, Ambulance.class));
        return modelMapper.map(ambulance, AmbulanceExposeDTO.class);
    }

    @Override
    public AmbulanceExposeDTO update(AmbulanceSeedDTO ambulanceSeedDTO, Long id) {
        Ambulance ambulance = ambulanceRepository.findById(id).orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.AMBULANCE_DOES_NOT_EXIST, id)));
        modelMapper.map(ambulanceSeedDTO, ambulance);
        ambulanceRepository.save(ambulance);
        return modelMapper.map(ambulance, AmbulanceExposeDTO.class);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ambulanceRepository.setDeletedStatus(id, true);
    }
}
