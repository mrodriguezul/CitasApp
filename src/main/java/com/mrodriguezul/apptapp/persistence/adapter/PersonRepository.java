package com.mrodriguezul.apptapp.persistence.adapter;

import com.mrodriguezul.apptapp.persistence.crud.PersonCrudRepository;
import com.mrodriguezul.apptapp.persistence.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    private PersonCrudRepository personCrudRepository;

    public PersonRepository(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }
    public List<PersonEntity> findByIdentificationIdOrderByIdentificationIdAsc(Long identificationId) {
        return personCrudRepository.findByIdentificationEntity_IdOrderByIdentificationEntity_IdAsc(identificationId);
    }
    public PersonEntity findPersonByIdentificationIdAndIdentificationNumber(Long identificationId, String identificationNumber) {
        return personCrudRepository.findPersonByIdentificationEntity_IdAndIdentificationNumber(identificationId, identificationNumber)
                .orElse(null);
    }

}
