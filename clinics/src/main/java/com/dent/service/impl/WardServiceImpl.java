package com.dent.service.impl;
import com.dent.exception.ExceptionMessages;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.WardExposeDTO;
import com.dent.model.dto.seed.WardSeedDTO;
import com.dent.model.entity.User;
import com.dent.model.entity.Ward;
import com.dent.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public WardServiceImpl(WardRepository wardRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.wardRepository = wardRepository;
        this.userRepository = userRepository;
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

    @Override
    public WardExposeDTO addUser(Long wardId, Long userId) {
        Ward ward = wardRepository.findById(wardId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.WARD_DOES_NOT_EXIST, wardId)));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.USER_DOES_NOT_EXIST, userId)));
        ward.getUsers().add(user);
        wardRepository.save(ward);
        return modelMapper.map(ward, WardExposeDTO.class);
    }
    @Override
    public WardExposeDTO removeUser(Long wardId, Long userId) {
        Ward ward = wardRepository.findById(wardId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.WARD_DOES_NOT_EXIST, wardId)));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.USER_DOES_NOT_EXIST, userId)));
        if (ward.getUsers().contains(user)) {
            ward.getUsers().remove(user);
            wardRepository.save(ward);
        }
        return modelMapper.map(ward, WardExposeDTO.class);
    }


}
