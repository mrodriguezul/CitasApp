package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Doctor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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

    @Mappings({
        @Mapping(source = "doctor", target = "person"),
        @Mapping(source = "identificacion", target = "person.identification"),
        @Mapping(source = "numeroIdentificacion", target = "person.identificationNumber"),
        @Mapping(source = "nombres", target = "person.names"),
        @Mapping(source = "apellidos", target = "person.surnames"),
        @Mapping(source = "fechaNacimiento", target = "person.dateOfBirth"),
        @Mapping(source = "email", target = "person.email"),
        @Mapping(source = "numeroTelefono", target = "person.phoneNumber"),
        @Mapping(source = "especialidad", target = "speciality")
    })
    com.mrodriguezul.citasapp.persistence.entity.Doctor toDoctorEntity(Doctor doctor);
}
