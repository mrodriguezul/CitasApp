package com.mrodriguezul.citasapp.persistence.adapter;

import com.mrodriguezul.citasapp.domain.model.User;
import com.mrodriguezul.citasapp.domain.repository.IUserRepository;
import com.mrodriguezul.citasapp.persistence.crud.UserCrudRepository;
import com.mrodriguezul.citasapp.persistence.mapper.UserPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final UserCrudRepository userCrudRepository;
    private final UserPersistenceMapper mapper;

    @Autowired
    public UserRepository(UserCrudRepository userCrudRepository, UserPersistenceMapper mapper) {
        this.userCrudRepository = userCrudRepository;
        this.mapper = mapper;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userCrudRepository.findById(username).map(mapper::toUsuario);
    }
}
