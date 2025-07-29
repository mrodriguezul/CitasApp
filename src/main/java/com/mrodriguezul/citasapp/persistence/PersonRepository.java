package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.persistence.crud.PersonCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Person;

import java.util.List;

public class PersonRepository {
    private PersonCrudRepository personCrudRepository;

    public PersonRepository(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }
    public List<Person> findByIdentificationIdOrderByIdentificationIdAsc(Long identificationId) {
        return personCrudRepository.findByIdentification_IdOrderByIdentification_IdAsc(identificationId);
    }
    public Person findPersonByIdentificationIdAndIdentificationNumber(Long identificationId, String identificationNumber) {
        return personCrudRepository.findPersonByIdentification_IdAndIdentificationNumber(identificationId, identificationNumber)
                .orElse(null);
    }

}
