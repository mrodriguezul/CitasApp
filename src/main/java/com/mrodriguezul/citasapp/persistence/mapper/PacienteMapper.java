package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Paciente;
import com.mrodriguezul.citasapp.persistence.entity.Patient;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PersonaMapper.class, IdentificacionMapper.class})
public interface PacienteMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "person.identification", target = "identificacion"),
        @Mapping(source = "person.identificationNumber", target = "numeroIdentificacion"),
        @Mapping(source = "person.names", target = "nombres"),
        @Mapping(source = "person.surnames", target = "apellidos"),
        @Mapping(source = "person.dateOfBirth", target = "fechaNacimiento"),
        @Mapping(source = "person.email", target = "email"),
        @Mapping(source = "person.phoneNumber", target = "numeroTelefono")
    })
    Paciente toPaciente(Patient patientEntity);

    @InheritConfiguration
    @Mappings({
            @Mapping(source = "id", target = "person.id"),
            @Mapping(target = "appointments", ignore = true)
    })
    Patient toPatientEntity(Paciente paciente);
}

