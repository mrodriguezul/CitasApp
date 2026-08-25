package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.model.Patient;
import com.mrodriguezul.citasapp.persistence.adapter.PatienteRepository;
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

    public Page<Patient> getAll(int page, int size) {
        return pacienteRepository.findAll(page, size);
    }

    public Page<Patient> getAllByIdentificationId(Long personIdentificationId, int page, int size, String sortBy, String sortDir) {
        return pacienteRepository.findAllByIdentificationId(personIdentificationId, page, size, sortBy, sortDir);
    }
}
