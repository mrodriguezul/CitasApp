package com.mrodriguezul.apptapp.persistence.crud;

import com.mrodriguezul.apptapp.persistence.entity.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PatientPagSortRepository extends ListPagingAndSortingRepository<PatientEntity, Long> {
    Page<PatientEntity> findAllByPersonEntity_IdentificationEntityId(Long personIdentificationId, Pageable pageable);
}
