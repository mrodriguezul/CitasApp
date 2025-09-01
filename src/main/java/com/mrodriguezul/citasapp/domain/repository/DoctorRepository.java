package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    List<Doctor> findAll();
    List<Doctor> findAllByNameOrSurname(String names, String surnames);
    List<Doctor> findAllBySpeciality(Long specialityId);
    List<Doctor> findByIdentificationNumber(String identificationNumber);
    Optional<Doctor> findById(Long id);
    Optional<Doctor> findByIdentificationTypeAndIdentificationNumber(Long identificationId, String identificationNumber);
    Doctor save(Doctor doctor);
    void delete(Long id);
    boolean existsById(Long id);
}

