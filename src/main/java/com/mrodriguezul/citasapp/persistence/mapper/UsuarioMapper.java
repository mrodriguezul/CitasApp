package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Rol;
import com.mrodriguezul.citasapp.domain.Usuario;
import com.mrodriguezul.citasapp.persistence.entity.UserEntity;
import com.mrodriguezul.citasapp.persistence.entity.UserRoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesToDomain")
    Usuario toUsuario(UserEntity userEntity);

    List<Usuario> toUsuarios(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    @Mapping(target = "roles", ignore = true)
    UserEntity toUserEntity(Usuario usuario);

    List<UserEntity> toUserEntities(List<Usuario> usuarios);

    @Named("mapRolesToDomain")
    default List<Rol> mapRolesToDomain(List<UserRoleEntity> roleEntities) {
        if (roleEntities == null) {
            return null;
        }
        return roleEntities.stream()
                .map(this::mapSingleRole)
                .collect(Collectors.toList());
    }

    default Rol mapSingleRole(UserRoleEntity roleEntity) {
        if (roleEntity == null) {
            return null;
        }
        Rol rol = new Rol();
        rol.setNombre(roleEntity.getRole());
        rol.setFechaAsignacion(roleEntity.getGrantedDate());
        return rol;
    }
}
