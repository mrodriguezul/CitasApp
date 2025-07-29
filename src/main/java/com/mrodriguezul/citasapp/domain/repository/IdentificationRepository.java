package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.persistence.entity.Identification;

import java.util.List;
import java.util.Optional;

public interface IdentificationRepository {
    List<Identification> findAll();
    Optional<Identification> findById(Long idIdentification);
    Identification save(Identification identification);
    void delete(Long idIdentification);
}
