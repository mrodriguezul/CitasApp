package com.mrodriguezul.apptapp.domain.repository;

import com.mrodriguezul.apptapp.domain.model.Patient;
import org.springframework.data.domain.Page;

public interface IPatientRepository {
    Page<Patient> findAll(int page, int size);
    Page<Patient> findAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir);
}
