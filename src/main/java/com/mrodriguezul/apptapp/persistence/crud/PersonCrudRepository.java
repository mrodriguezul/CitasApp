package com.mrodriguezul.apptapp.persistence.crud;

import com.mrodriguezul.apptapp.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonCrudRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findByIdentificationEntity_IdOrderByIdentificationEntity_IdAsc(Long identification);
    Optional<PersonEntity> findPersonByIdentificationEntity_IdAndIdentificationNumber(Long identificationId, String identificationNumber);
}
