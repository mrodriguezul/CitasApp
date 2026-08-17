package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Identificacion;

import java.util.List;
import java.util.Optional;

public interface IIdentificationRepository {
    List<Identificacion> findAll();
    Optional<Identificacion> findById(Long idIdentificacion);
    boolean existsById(Long idIdentificacion);
    Identificacion save(Identificacion identificacion);
    void delete(Long idIdentificacion);
}
