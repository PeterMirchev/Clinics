package com.dent.repository;
import com.dent.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("""
           SELECT c FROM City c
           WHERE c.isDeleted = false
           """)
    Collection<City> findALl();

    @Modifying
    @Query("""
           UPDATE City c
           SET c.isDeleted = :isDeleted
           WHERE c.id = :id
           """)
    int setDeleteStatus(@Param("id") Long id, @Param("isDeleted") boolean isDeleted);

    @Query("""
           SELECT COUNT(c)
           FROM City c
           WHERE c.isDeleted = false
           """)
    long count();

    @Query("""
           SELECT c
           FROM City  c
           WHERE c.id = :id
           AND c.isDeleted = false
           """)
    @Override
    Optional<City> findById(@Param("id") Long id);

}
