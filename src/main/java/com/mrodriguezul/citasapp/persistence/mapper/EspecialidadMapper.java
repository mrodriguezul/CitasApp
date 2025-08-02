package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Especialidad;
import com.mrodriguezul.citasapp.persistence.entity.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "nombre")
    })
    Especialidad toEspecialidad(Speciality specialityEntity);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name")
    })
    Speciality toSpecialityEntity(Especialidad especialidad);
}

