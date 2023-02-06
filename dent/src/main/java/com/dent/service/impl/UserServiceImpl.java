package com.dent.service.impl;

import com.dent.exception.ExceptionMessages;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.dto.seed.UserSeedDTO;
import com.dent.model.entity.Doctor;
import com.dent.model.entity.User;
import com.dent.model.enums.Role;
import com.dent.model.enums.UserType;
import com.dent.repository.UserRepository;
import com.dent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long count() {
        return userRepository.count();
    }


    @Override
    public Collection<UserExposeDTO> findAll(UserType userType, Role role) {
        return userRepository.findAll(role, userType)
                .stream()
                .map(dto -> modelMapper.map(dto, UserExposeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserExposeDTO findById(Long id) {
        return userRepository.findById(id)
                .map(dto -> modelMapper.map(dto, UserExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.USER_DOES_NOT_EXIST, id)));
    }

    @Override
    public UserExposeDTO create(UserSeedDTO userSeedDTO) {
        User userToBePersisted = modelMapper.map(userSeedDTO, userSeedDTO.getUserType().equals(UserType.DOCTOR) ? Doctor.class : User.class);
        userToBePersisted.getRole().add(Role.BASIC);
        return modelMapper.map(userRepository.save(userToBePersisted), UserExposeDTO.class);
    }

    @Override
    public UserExposeDTO update(UserSeedDTO userSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
