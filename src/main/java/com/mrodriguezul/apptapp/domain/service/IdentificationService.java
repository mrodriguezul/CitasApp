package com.mrodriguezul.apptapp.domain.service;

import com.mrodriguezul.apptapp.domain.model.Identification;
import com.mrodriguezul.apptapp.domain.repository.IIdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificationService {

    @Autowired
    private IIdentificationRepository IIdentificationRepository;

    public List<Identification> getAll(){
        return IIdentificationRepository.findAll();
    }

    public Optional<Identification> getIdentificacion(Long idIdentificacion){
        return IIdentificationRepository.findById(idIdentificacion);
    }

    public boolean existsById(Long idIdentificacion){
        return IIdentificationRepository.existsById(idIdentificacion);
    }

    public Identification save(Identification identification){
        return IIdentificationRepository.save(identification);
    }

    public boolean delete(Long idIdentificacion){
        return getIdentificacion(idIdentificacion).map(identificacion -> {
            IIdentificationRepository.delete(idIdentificacion);
            return true;
        }).orElse(false);
    }
}
