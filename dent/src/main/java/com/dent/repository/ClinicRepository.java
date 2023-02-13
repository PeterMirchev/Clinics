package com.dent.repository;
import com.dent.model.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    @Query("""
           SELECT c FROM Clinic c 
           WHERE c.isDeleted = false
           """)
    List<Clinic> findAll();

    @Modifying
    @Query("""
           UPDATE Clinic c
           SET c.isDeleted = :isDeleted
           WHERE c.id = :id
           """)
    int setDeleteStatus(@Param("id") Long id, @Param("isDeleted") boolean isDeleted);

    @Query("""
           SELECT COUNT(c)
           FROM Clinic c
           WHERE c.isDeleted = false
           """)
    long count();

    @Query("""
           SELECT c
           FROM Clinic c
           WHERE c.id = :id
           AND c.isDeleted = false
           """)
    @Override
    Optional<Clinic> findById(@Param("id") Long id);
}
