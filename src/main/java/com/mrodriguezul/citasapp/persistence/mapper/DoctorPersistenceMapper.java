package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.model.Doctor;
import com.mrodriguezul.citasapp.persistence.entity.DoctorEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PersonPersistenceMapper.class, IdentificationPersistenceMapper.class, SpecialityPersistenceMapper.class})
public interface DoctorPersistenceMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "personEntity.identificationEntity", target = "identificacion"),
        @Mapping(source = "personEntity.identificationNumber", target = "numeroIdentificacion"),
        @Mapping(source = "personEntity.names", target = "nombres"),
        @Mapping(source = "personEntity.surnames", target = "apellidos"),
        @Mapping(source = "personEntity.dateOfBirth", target = "fechaNacimiento"),
        @Mapping(source = "personEntity.email", target = "email"),
        @Mapping(source = "personEntity.phoneNumber", target = "numeroTelefono"),
        @Mapping(source = "specialityEntity", target = "especialidad")
    })
    Doctor toDoctor(DoctorEntity doctorEntity);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(source = "id", target = "personEntity.id"),
        @Mapping(target = "appointments", ignore = true)
    })
    DoctorEntity toDoctorEntity(Doctor doctor);
}
