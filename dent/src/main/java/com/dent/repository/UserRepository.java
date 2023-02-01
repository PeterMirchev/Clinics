package com.dent.repository;

import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
