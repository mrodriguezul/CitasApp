package com.mrodriguezul.citasapp.domain.repository;

import com.mrodriguezul.citasapp.domain.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByUsername(String username);

}
