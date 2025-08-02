package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.Identificacion;
import com.mrodriguezul.citasapp.domain.repository.IdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificacionService {

    @Autowired
    private IdentificacionRepository identificacionRepository;

    public List<Identificacion> getAll(){
        return identificacionRepository.findAll();
    }

    public Optional<Identificacion> getIdentificacion(Long idIdentificacion){
        return identificacionRepository.findById(idIdentificacion);
    }

    public Identificacion save(Identificacion identificacion){
        return identificacionRepository.save(identificacion);
    }

    public boolean delete(Long idIdentificacion){
        return getIdentificacion(idIdentificacion).map(identificacion -> {
            identificacionRepository.delete(idIdentificacion);
            return true;
        }).orElse(false);
    }
}
