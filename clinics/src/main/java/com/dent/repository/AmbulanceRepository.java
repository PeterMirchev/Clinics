package com.dent.repository;
import com.dent.model.entity.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {
    @Query("""
           SELECT a FROM Ambulance a
           WHERE a.isDeleted = false
           """)
    List<Ambulance> findAll();

    @Modifying
    @Query("""
           UPDATE Ambulance a
           SET a.isDeleted = :isDeleted
           WHERE a.id = :id
           """)
    int setDeletedStatus(@Param("id") Long id, @Param("isDeleted") boolean isDeleted);

    @Query("""
           SELECT COUNT(a)
           FROM Ambulance a
           WHERE a.isDeleted = false
           """)
    long count();


    @Query("""
           SELECT a
           FROM Ambulance a
           WHERE a.id = :id
           AND a.isDeleted = false
           """)
    Optional<Ambulance> findById(@Param("id") Long id);
}
