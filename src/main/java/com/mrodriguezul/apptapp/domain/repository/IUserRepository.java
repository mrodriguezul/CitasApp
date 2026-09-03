package com.mrodriguezul.apptapp.domain.repository;

import com.mrodriguezul.apptapp.domain.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByUsername(String username);

}
