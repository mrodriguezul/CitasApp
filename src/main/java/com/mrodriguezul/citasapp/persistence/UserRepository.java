package com.mrodriguezul.citasapp.persistence;

import com.mrodriguezul.citasapp.domain.Usuario;
import com.mrodriguezul.citasapp.domain.repository.IUsuarioRepository;
import com.mrodriguezul.citasapp.persistence.crud.UserCrudRepository;
import com.mrodriguezul.citasapp.persistence.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements IUsuarioRepository {
    private final UserCrudRepository userCrudRepository;
    private final UsuarioMapper mapper;

    @Autowired
    public UserRepository(UserCrudRepository userCrudRepository, UsuarioMapper mapper) {
        this.userCrudRepository = userCrudRepository;
        this.mapper = mapper;
    }


    @Override
    public Optional<Usuario> findByUsername(String username) {
        return userCrudRepository.findById(username).map(mapper::toUsuario);
    }
}
