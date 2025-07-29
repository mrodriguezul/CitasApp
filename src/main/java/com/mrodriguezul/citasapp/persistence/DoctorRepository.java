package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.persistence.crud.DoctorCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Doctor;

import java.util.List;

public class DoctorRepository {
    private DoctorCrudRepository doctorCrudRepository;

    public DoctorRepository(DoctorCrudRepository doctorCrudRepository) {
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
    }

}
