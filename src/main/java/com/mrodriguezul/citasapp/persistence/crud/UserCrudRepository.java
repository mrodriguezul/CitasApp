package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserEntity, String> {

}
