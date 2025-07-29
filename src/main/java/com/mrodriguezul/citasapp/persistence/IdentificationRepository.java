package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.persistence.crud.IdentificationCrudRepository;
import com.mrodriguezul.citasapp.persistence.entity.Identification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IdentificationRepository {
    private IdentificationCrudRepository identificationCrudRepository;

    public IdentificationRepository(IdentificationCrudRepository productCrudRepository) {
        this.identificationCrudRepository = productCrudRepository;
    }

    public List<Identification> findAll() {
        return (List<Identification>) identificationCrudRepository.findAll();
    }

    public Identification findById(Long idIdentification) {
        return identificationCrudRepository.findById(idIdentification).orElse(null);
    }

    public Identification save(Identification identification) {
        return identificationCrudRepository.save(identification);
    }

    public void delete(Long idIdentification) {
        identificationCrudRepository.deleteById(idIdentification);
    }

}
