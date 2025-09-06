package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PatientPagSortRepository extends ListPagingAndSortingRepository<Patient, Long> {
    Page<Patient> findAllByPerson_IdentificationId(Long personIdentificationId, Pageable pageable);
}
