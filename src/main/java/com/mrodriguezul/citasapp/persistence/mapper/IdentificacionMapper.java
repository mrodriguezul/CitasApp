package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Identificacion;
import com.mrodriguezul.citasapp.persistence.entity.Identification;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IdentificacionMapper {
    @Mappings({
            @Mapping(source = "id", target = "idIdentificacion"),
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "description", target = "descripcion")
    })
    Identificacion toIdentificacion(Identification identification);

    @InheritInverseConfiguration
    @Mapping(target = "persons", ignore = true)
    Identification toIdentification(Identificacion identificacion);

    List<Identificacion> toIdentificaciones(List<Identification> identifications);
}

