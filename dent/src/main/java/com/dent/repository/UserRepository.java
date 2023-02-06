package com.dent.repository;

import com.dent.model.entity.User;
import com.dent.model.enums.Role;
import com.dent.model.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT u FROM User u 
            WHERE (:role is null
            OR u.role = :role)
            AND (:userType is null 
            OR u.userType = :userType)
             """)
    Collection<User> findAll(@Param("role") Role role, @Param("userType") UserType userType);
}
