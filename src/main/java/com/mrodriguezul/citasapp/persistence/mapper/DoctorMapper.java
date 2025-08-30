package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Doctor;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PersonaMapper.class, IdentificacionMapper.class, EspecialidadMapper.class})
public interface DoctorMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "person.identification", target = "identificacion"),
        @Mapping(source = "person.identificationNumber", target = "numeroIdentificacion"),
        @Mapping(source = "person.names", target = "nombres"),
        @Mapping(source = "person.surnames", target = "apellidos"),
        @Mapping(source = "person.dateOfBirth", target = "fechaNacimiento"),
        @Mapping(source = "person.email", target = "email"),
        @Mapping(source = "person.phoneNumber", target = "numeroTelefono"),
        @Mapping(source = "speciality", target = "especialidad")
    })
    Doctor toDoctor(com.mrodriguezul.citasapp.persistence.entity.Doctor doctorEntity);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(source = "id", target = "person.id"),
        @Mapping(target = "appointments", ignore = true)
    })
    com.mrodriguezul.citasapp.persistence.entity.Doctor toDoctorEntity(Doctor doctor);
}
