package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.domain.model.Identificacion;
import com.mrodriguezul.citasapp.domain.repository.IIdentificationRepository;
import com.mrodriguezul.citasapp.persistence.crud.IdentificationCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Identification;
import com.mrodriguezul.citasapp.persistence.mapper.IdentificacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IdentificationRepository implements IIdentificationRepository {

    private IdentificationCrudRepository identificationCrudRepository;
    private IdentificacionMapper mapper;

    @Autowired
    public IdentificationRepository(IdentificationCrudRepository identificationCrudRepository, IdentificacionMapper mapper) {
        this.identificationCrudRepository = identificationCrudRepository;
        this.mapper = mapper;
    }

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
    public boolean existsById(Long idIdentificacion) {
        return this.identificationCrudRepository.existsById(idIdentificacion);
    }

    @Override
    public Identificacion save(Identificacion identificacion) {
        Identification identification = mapper.toIdentification(identificacion);
        //identificationCrudRepository.existsById(identification.getId());
        return mapper.toIdentificacion(identificationCrudRepository.save(identification));
    }

    @Override
    public void delete(Long idIdentificacion) {
        identificationCrudRepository.deleteById(idIdentificacion);
    }

}
