package com.mrodriguezul.apptapp.persistence.adapter;

import com.mrodriguezul.apptapp.domain.model.Identification;
import com.mrodriguezul.apptapp.domain.repository.IIdentificationRepository;
import com.mrodriguezul.apptapp.persistence.crud.IdentificationCrudRepository;
import com.mrodriguezul.apptapp.persistence.entity.IdentificationEntity;
import com.mrodriguezul.apptapp.persistence.mapper.IdentificationPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IdentificationRepository implements IIdentificationRepository {

    private IdentificationCrudRepository identificationCrudRepository;
    private IdentificationPersistenceMapper mapper;

    @Autowired
    public IdentificationRepository(IdentificationCrudRepository identificationCrudRepository, IdentificationPersistenceMapper mapper) {
        this.identificationCrudRepository = identificationCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Identification> findAll() {
        List<IdentificationEntity> lstIdentifications = (List<IdentificationEntity>) identificationCrudRepository.findAll();
        return mapper.toIdentificaciones(lstIdentifications);
    }

    @Override
    public Optional<Identification> findById(Long idIdentificacion) {
        Optional<IdentificationEntity> identification = identificationCrudRepository.findById(idIdentificacion);
        return identification.map(mapper::toIdentificacion);
    }

    @Override
    public boolean existsById(Long idIdentificacion) {
        return this.identificationCrudRepository.existsById(idIdentificacion);
    }

    @Override
    public Identification save(Identification identification) {
        IdentificationEntity identificationEntity = mapper.toIdentification(identification);
        //identificationCrudRepository.existsById(identificationEntity.getId());
        return mapper.toIdentificacion(identificationCrudRepository.save(identificationEntity));
    }

    @Override
    public void delete(Long idIdentificacion) {
        identificationCrudRepository.deleteById(idIdentificacion);
    }

}
