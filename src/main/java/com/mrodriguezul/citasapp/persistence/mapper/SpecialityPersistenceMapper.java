package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.model.Speciality;
import com.mrodriguezul.citasapp.persistence.entity.SpecialityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SpecialityPersistenceMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "nombre")
    })
    Speciality toEspecialidad(SpecialityEntity specialityEntity);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name")
    })
    SpecialityEntity toSpecialityEntity(Speciality speciality);
}

