package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.model.Paciente;
import org.springframework.data.domain.Page;

public interface IPacienteRepository {
    Page<Paciente> findAll(int page, int size);
    Page<Paciente> findAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir);
}
