package com.mrodriguezul.citasapp.persistence.adapter;

import com.mrodriguezul.citasapp.domain.model.Patient;
import com.mrodriguezul.citasapp.domain.repository.IPatientRepository;
import com.mrodriguezul.citasapp.persistence.crud.PatientPagSortRepository;
import com.mrodriguezul.citasapp.persistence.mapper.PatientPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class PatienteRepository implements IPatientRepository {

    private final PatientPagSortRepository patientPagSortRepository;
    private final PatientPersistenceMapper patientPersistenceMapper;

    @Autowired
    public PatienteRepository(PatientPagSortRepository patientPagSortRepository, PatientPersistenceMapper patientPersistenceMapper) {
        this.patientPagSortRepository = patientPagSortRepository;
        this.patientPersistenceMapper = patientPersistenceMapper;
    }

    @Override
    public Page<Patient> findAll(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);

        return patientPagSortRepository.findAll(pageable).map(patientPersistenceMapper::toPaciente);
    }

    @Override
    public Page<Patient> findAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return patientPagSortRepository.findAllByPersonEntity_IdentificationEntityId(personIdentificationId, pageable).map(patientPersistenceMapper::toPaciente);
    }
}
