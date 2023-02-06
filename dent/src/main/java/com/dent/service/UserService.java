package com.dent.service;

import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.dto.seed.UserSeedDTO;
import com.dent.model.enums.Role;
import com.dent.model.enums.UserType;

import java.util.Collection;

public interface UserService {
    Long count();
    Collection<UserExposeDTO> findAll(UserType userType, Role role);
    UserExposeDTO findById(Long id);
    UserExposeDTO create(UserSeedDTO userSeedDTO);
    UserExposeDTO update(UserSeedDTO userSeedDTO, Long id);
    void deleteById(Long id);

}
