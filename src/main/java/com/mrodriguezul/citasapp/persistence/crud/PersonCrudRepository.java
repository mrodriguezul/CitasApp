package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonCrudRepository extends JpaRepository<Person, Long> {
    List<Person> findByIdentification_IdOrderByIdentification_IdAsc(Long identification);
    Optional<Person> findPersonByIdentification_IdAndIdentificationNumber(Long identificationId, String identificationNumber);
}
