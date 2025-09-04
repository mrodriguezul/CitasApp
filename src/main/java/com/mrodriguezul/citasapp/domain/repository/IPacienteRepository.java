package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Paciente;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPacienteRepository {
    Page<Paciente> findAll(int page, int size);
}
