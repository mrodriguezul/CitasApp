package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.model.Identification;
import com.mrodriguezul.citasapp.persistence.entity.IdentificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IdentificationPersistenceMapper {
    @Mappings({
            @Mapping(source = "id", target = "idIdentificacion"),
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "description", target = "descripcion")
    })
    Identification toIdentificacion(IdentificationEntity identificationEntity);

    @InheritInverseConfiguration
    @Mapping(target = "persons", ignore = true)
    IdentificationEntity toIdentification(Identification identification);

    List<Identification> toIdentificaciones(List<IdentificationEntity> identificationEntities);
}

