package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.Identification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IdentificationCrudRepository extends CrudRepository<Identification, Long> {
    Optional<Identification> findById(Long identificationId);
    Optional<Identification> findByName(String name);
    List<Identification> findByIdOrderByIdAsc(Long identificationId);
    List<Identification> findAllByOrderByIdAsc();
    //SELECT * FROM identification WHERE LOWER(name) LIKE LOWER(CONCAT('%', ?1, '%'))
    @Query("SELECT i FROM Identification i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Identification> findByNameContainingIgnoreCase(@Param("name") String name);

}
