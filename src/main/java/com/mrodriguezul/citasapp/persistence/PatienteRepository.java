package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.domain.Paciente;
import com.mrodriguezul.citasapp.domain.repository.IPacienteRepository;
import com.mrodriguezul.citasapp.persistence.crud.PatientPagSortRepository;
import com.mrodriguezul.citasapp.persistence.entity.Patient;
import com.mrodriguezul.citasapp.persistence.mapper.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class PatienteRepository implements IPacienteRepository {

    private final PatientPagSortRepository patientPagSortRepository;
    private final PacienteMapper pacienteMapper;

    @Autowired
    public PatienteRepository(PatientPagSortRepository patientPagSortRepository, PacienteMapper pacienteMapper) {
        this.patientPagSortRepository = patientPagSortRepository;
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public Page<Paciente> findAll(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);

        return patientPagSortRepository.findAll(pageable).map(pacienteMapper::toPaciente);
    }

    @Override
    public Page<Paciente> findAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return patientPagSortRepository.findAllByPerson_IdentificationId(personIdentificationId, pageable).map(pacienteMapper::toPaciente);
    }
}
