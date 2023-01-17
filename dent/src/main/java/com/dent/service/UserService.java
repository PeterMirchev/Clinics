package com.dent.service;

import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.dto.seed.UserSeedDTO;

import java.util.Collection;

public interface UserService {
    Integer count();
    Integer countAdministrators(String administrators);
    Collection<UserExposeDTO> findAll();
    UserExposeDTO findById(Long id);
    UserExposeDTO create(UserSeedDTO userSeedDTO);
    UserExposeDTO update(UserSeedDTO userSeedDTO, Long id);
    void deleteById(Long id);

}
