package com.dent.service.impl;
import com.dent.exception.ExceptionMessages;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.WardExposeDTO;
import com.dent.model.dto.seed.WardSeedDTO;
import com.dent.model.entity.Ward;
import com.dent.repository.WardRepository;
import com.dent.service.WardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class WardServiceImpl implements WardService {
    private final WardRepository wardRepository;
    private final ModelMapper modelMapper;


    public WardServiceImpl(WardRepository wardRepository, ModelMapper modelMapper) {
        this.wardRepository = wardRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long count() {
        return wardRepository.count();
    }

    @Override
    public Collection<WardExposeDTO> findAll() {
        return wardRepository.findAll()
                .stream()
                .map((dto -> modelMapper.map(dto, WardExposeDTO.class)))
                .collect(Collectors.toList());
    }

    @Override
    public WardExposeDTO findById(Long id) {
        return wardRepository.findById(id)
                .map(dto -> modelMapper.map(dto, WardExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.WARD_DOES_NOT_EXIST, id)));
    }

    @Override
    public WardExposeDTO create(WardSeedDTO wardSeedDTO) {
        Ward ward = wardRepository.save(modelMapper.map(wardSeedDTO, Ward.class));
        return modelMapper.map(ward, WardExposeDTO.class);
    }

    @Override
    public WardExposeDTO update(WardSeedDTO wardSeedDTO, Long id) {
        Ward ward = wardRepository.findById(id).orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.WARD_DOES_NOT_EXIST, id)));
        modelMapper.map(wardSeedDTO, ward);
        wardRepository.save(ward);
        return modelMapper.map(ward, WardExposeDTO.class);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        wardRepository.setDeleteStatus(id, true);
    }


}
