package com.dent.repository;
import com.dent.model.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {

    @Query("""
            SELECT w FROM Ward w
            WHERE w.isDeleted = false
            """)
    List<Ward> findAll();

    @Modifying
    @Query("""
            UPDATE Ward w
            SET w.isDeleted = :isDeleted
            WHERE w.id = :id
            """)
    int setDeleteStatus(@Param("id") Long id, @Param("isDeleted") boolean isDeleted);

    @Query("""
            SELECT COUNT(w)
            FROM Ward w
            WHERE w.isDeleted = false 
            """)
    long count();

    @Query("""
           SELECT w
           FROM Ward w
           WHERE w.id = :id
           AND w.isDeleted = false
           """)
    @Override
    Optional<Ward> findById(@Param("id") Long id);
}
