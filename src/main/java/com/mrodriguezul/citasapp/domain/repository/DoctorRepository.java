package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    Doctor save(Doctor doctor);
    void delete(Long id);
}

