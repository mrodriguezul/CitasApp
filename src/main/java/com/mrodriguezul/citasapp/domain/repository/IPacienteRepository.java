package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Paciente;
import com.mrodriguezul.citasapp.persistence.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPacienteRepository {
    Page<Paciente> findAll(int page, int size);
    Page<Paciente> findAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir);
}
