package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PacienteRepository {
    Page<Paciente> findAll(int page, int size);
    Page<Paciente> findAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir);
}