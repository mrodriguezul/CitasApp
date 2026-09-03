package com.mrodriguezul.apptapp.persistence.crud;

import com.mrodriguezul.apptapp.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserEntity, String> {

}
