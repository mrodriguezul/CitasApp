package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.model.Identification;

import java.util.List;
import java.util.Optional;

public interface IIdentificationRepository {
    List<Identification> findAll();
    Optional<Identification> findById(Long idIdentificacion);
    boolean existsById(Long idIdentificacion);
    Identification save(Identification identification);
    void delete(Long idIdentificacion);
}
