package com.dent.service.impl;
import com.dent.exception.ExceptionMessages;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.CityExposeDTO;
import com.dent.model.dto.seed.CitySeedDTO;
import com.dent.model.entity.City;
import com.dent.model.entity.Clinic;
import com.dent.repository.CityRepository;
import com.dent.repository.ClinicRepository;
import com.dent.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ClinicRepository clinicRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ClinicRepository clinicRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.clinicRepository = clinicRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public long count() {
        return cityRepository.count();
    }

    @Override
    public Collection<CityExposeDTO> findAll() {
        return cityRepository.findALl()
                .stream().map(dto -> modelMapper.map(dto, CityExposeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CityExposeDTO findById(Long id) throws NonExistingEntityException {
        return cityRepository.findById(id)
                .map(dto -> modelMapper.map(dto, CityExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CITY_DOES_NOT_EXIST, id)));
    }

    @Override
    public CityExposeDTO create(CitySeedDTO citySeedDTO) {
        City city = cityRepository.save(modelMapper.map(citySeedDTO, City.class));
        return modelMapper.map(city, CityExposeDTO.class);
    }

    @Override
    public CityExposeDTO update(CitySeedDTO citySeedDTO, Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CITY_DOES_NOT_EXIST, id)));
        modelMapper.map(citySeedDTO, city);
        cityRepository.save(city);
        return modelMapper.map(city, CityExposeDTO.class);
    }

    @Transactional
    public CityExposeDTO addClinic(Long cityId, Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CLINIC_DOES_NOT_EXIST, clinicId)));
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CITY_DOES_NOT_EXIST, clinicId)));
        city.getClinics().add(clinic);
        cityRepository.save(city);
        return modelMapper.map(city, CityExposeDTO.class);
    }

    public CityExposeDTO removeClinic(Long cityId, Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CLINIC_DOES_NOT_EXIST, clinicId)));
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CITY_DOES_NOT_EXIST, clinicId)));
        city.getClinics().remove(clinic);
        cityRepository.save(city);
        return modelMapper.map(city, CityExposeDTO.class);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cityRepository.setDeleteStatus(id, true);
    }
}
