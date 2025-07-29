package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.domain.Identificacion;
import com.mrodriguezul.citasapp.domain.repository.IdentificacionRepository;
import com.mrodriguezul.citasapp.persistence.crud.IdentificationCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Identification;
import com.mrodriguezul.citasapp.persistence.mapper.IdentificacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IdentificationRepository implements IdentificacionRepository {
    @Autowired
    private IdentificationCrudRepository identificationCrudRepository;
    @Autowired
    private IdentificacionMapper mapper;

    /*public IdentificationRepository(IdentificationCrudRepository productCrudRepository) {
        this.identificationCrudRepository = productCrudRepository;
    }*/

    @Override
    public List<Identificacion> findAll() {
        List<Identification> lstIdentifications = (List<Identification>) identificationCrudRepository.findAll();
        return mapper.toIdentificaciones(lstIdentifications);
    }

    @Override
    public Optional<Identificacion> findById(Long idIdentificacion) {
        Optional<Identification> identification = identificationCrudRepository.findById(idIdentificacion);
        return identification.map(mapper::toIdentificacion);
    }

    @Override
    public Identificacion save(Identificacion identificacion) {
        Identification identification = mapper.toIdentification(identificacion);
        return mapper.toIdentificacion(identificationCrudRepository.save(identification));
    }

    @Override
    public void delete(Long idIdentificacion) {
        identificationCrudRepository.deleteById(idIdentificacion);
    }

}
