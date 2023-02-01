package com.dent.service.impl;

import com.dent.exception.ExceptionMessages;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.ClinicExposeDTO;
import com.dent.model.dto.seed.ClinicSeedDTO;
import com.dent.model.entity.Clinic;
import com.dent.repository.ClinicRepository;
import com.dent.service.ClinicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final ModelMapper modelMapper;
    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicServiceImpl(ModelMapper modelMapper, ClinicRepository clinicRepository) {
        this.modelMapper = modelMapper;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public Long count() {
        return clinicRepository.count();
    }

    @Override
    public Collection<ClinicExposeDTO> findAll() {
        return clinicRepository.findAll().stream()
                .map(dto ->modelMapper.map(dto, ClinicExposeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClinicExposeDTO findById(Long id) throws NonExistingEntityException {
        return clinicRepository.findById(id)
                .map(dto -> modelMapper.map(dto, ClinicExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CLINIC_DOES_NOT_EXIST, id)));
    }

    @Override
    public ClinicExposeDTO create(ClinicSeedDTO clinicSeedDTO) {
        Clinic clinic = clinicRepository.save(modelMapper.map(clinicSeedDTO, Clinic.class));
        return modelMapper.map(clinic, ClinicExposeDTO.class);
    }

    @Override
    public ClinicExposeDTO update(ClinicSeedDTO clinicSeedDTO, Long id) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CLINIC_DOES_NOT_EXIST, id)));
        modelMapper.map(clinicSeedDTO, clinic);
        clinicRepository.save(clinic);
        return modelMapper.map(clinic, ClinicExposeDTO.class);
    }

    @Override
    public void deleteById(Long id) {

    }
}
