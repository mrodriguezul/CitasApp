package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.model.Identificacion;
import com.mrodriguezul.citasapp.domain.repository.IIdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificacionService {

    @Autowired
    private IIdentificationRepository IIdentificationRepository;

    public List<Identificacion> getAll(){
        return IIdentificationRepository.findAll();
    }

    public Optional<Identificacion> getIdentificacion(Long idIdentificacion){
        return IIdentificationRepository.findById(idIdentificacion);
    }

    public boolean existsById(Long idIdentificacion){
        return IIdentificationRepository.existsById(idIdentificacion);
    }

    public Identificacion save(Identificacion identificacion){
        return IIdentificationRepository.save(identificacion);
    }

    public boolean delete(Long idIdentificacion){
        return getIdentificacion(idIdentificacion).map(identificacion -> {
            IIdentificationRepository.delete(idIdentificacion);
            return true;
        }).orElse(false);
    }
}
