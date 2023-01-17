package com.dent.service.impl;

import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.dto.seed.UserSeedDTO;
import com.dent.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Integer count() {
        return null;
    }

    @Override
    public Integer countAdministrators(String administrators) {
        return null;
    }

    @Override
    public Collection<UserExposeDTO> findAll() {
        return null;
    }

    @Override
    public UserExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public UserExposeDTO create(UserSeedDTO userSeedDTO) {
        return null;
    }

    @Override
    public UserExposeDTO update(UserSeedDTO userSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
