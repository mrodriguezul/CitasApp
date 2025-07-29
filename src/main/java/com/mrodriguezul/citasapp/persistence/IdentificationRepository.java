package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.persistence.crud.IdentificationCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Identification;

import java.util.List;

public class IdentificationRepository {
    private IdentificationCrudRepository identificationCrudRepository;

    public IdentificationRepository(IdentificationCrudRepository productCrudRepository) {
        this.identificationCrudRepository = productCrudRepository;
    }

    public List<Identification> findAll() {
        return (List<Identification>) identificationCrudRepository.findAll();
    }


}
