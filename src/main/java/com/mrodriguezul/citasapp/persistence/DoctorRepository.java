package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.domain.Doctor;
import com.mrodriguezul.citasapp.persistence.crud.DoctorCrudRepository;
import com.mrodriguezul.citasapp.persistence.crud.PersonCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Person;
import com.mrodriguezul.citasapp.persistence.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository implements com.mrodriguezul.citasapp.domain.repository.DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Autowired
    private DoctorMapper mapper;

    @Override
    public List<Doctor> findAll() {
        return ((List<com.mrodriguezul.citasapp.persistence.entity.Doctor>) doctorCrudRepository.findAll())
                .stream()
                .map(mapper::toDoctor)
                .toList();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorCrudRepository.findById(id)
                .map(mapper::toDoctor);
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        com.mrodriguezul.citasapp.persistence.entity.Doctor doctorEntity = mapper.toDoctorEntity(doctor);

        Person personEntity = doctorEntity.getPerson();
        Person savedPerson = personCrudRepository.save(personEntity);

        doctorEntity.setPerson(savedPerson);
        doctorEntity.setId(null);

        com.mrodriguezul.citasapp.persistence.entity.Doctor savedDoctor = doctorCrudRepository.save(doctorEntity);
        return mapper.toDoctor(savedDoctor);
    }

    @Override
    public void delete(Long id) {
        doctorCrudRepository.deleteById(id);
    }


    /*public DoctorRepository(DoctorCrudRepository doctorCrudRepository) {
        this.doctorCrudRepository = doctorCrudRepository;
    }

    List<Doctor> findBySpecialityIdOrderBySpecialityId(Long id) {
        return doctorCrudRepository.findBySpeciality_IdOrderBySpeciality_Id(id);
    }

    Doctor findByPersonId(Long personId) {
        return doctorCrudRepository.findByPerson_Id(personId).orElse(null);
    }

    Doctor findByPersonIdAndPersonIdentificationNumber(Long personId, String identificationNumber) {
        return doctorCrudRepository.findByPerson_IdAndPerson_IdentificationNumber(personId, identificationNumber)
                .orElse(null);
    }

    Doctor findByPersonIdentificationIdAndPersonIdentificationNumber(Long identificationId, String identificationNumber) {
        return doctorCrudRepository.findByPerson_IdentificationIdAndPerson_IdentificationNumber(identificationId, identificationNumber)
                .orElse(null);
    }*/

}
