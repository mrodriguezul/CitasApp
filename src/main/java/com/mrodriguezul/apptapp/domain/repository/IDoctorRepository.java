package com.mrodriguezul.apptapp.domain.repository;

import com.mrodriguezul.apptapp.domain.model.Doctor;
import java.util.List;
import java.util.Optional;

public interface IDoctorRepository {
    List<Doctor> findAll();
    List<Doctor> findAllByNameOrSurname(String names, String surnames);
    List<Doctor> findAllBySpeciality(Long specialityId);
    Optional<Doctor> findByIdentificationNumber(String identificationNumber);
    Optional<Doctor> findById(Long id);
    Optional<Doctor> findByIdentificationTypeAndIdentificationNumber(Long identificationId, String identificationNumber);
    Doctor save(Doctor doctor);
    void delete(Long id);
    boolean existsById(Long id);
}

