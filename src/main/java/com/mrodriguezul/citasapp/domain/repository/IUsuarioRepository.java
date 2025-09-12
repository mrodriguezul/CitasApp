package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.Usuario;

import java.util.Optional;

public interface IUsuarioRepository {
    Optional<Usuario> findByUsername(String username);

}
