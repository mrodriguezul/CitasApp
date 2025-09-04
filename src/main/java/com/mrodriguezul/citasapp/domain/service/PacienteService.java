package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.Doctor;
import com.mrodriguezul.citasapp.domain.Paciente;
import com.mrodriguezul.citasapp.persistence.PatienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private final PatienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PatienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Page<Paciente> getAll(int page, int size) {
        return pacienteRepository.findAll(page, size);
    }
}
