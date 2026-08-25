package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.IdentificationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IdentificationCrudRepository extends CrudRepository<IdentificationEntity, Long> {
    Optional<IdentificationEntity> findById(Long identificationId);
    Optional<IdentificationEntity> findByName(String name);
    List<IdentificationEntity> findByIdOrderByIdAsc(Long identificationId);
    List<IdentificationEntity> findAllByOrderByIdAsc();
    //SELECT * FROM identification WHERE LOWER(name) LIKE LOWER(CONCAT('%', ?1, '%'))
    @Query("SELECT i FROM IdentificationEntity i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<IdentificationEntity> findByNameContainingIgnoreCase(@Param("name") String name);

}
