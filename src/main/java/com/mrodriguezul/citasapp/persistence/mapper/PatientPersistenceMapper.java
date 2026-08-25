package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.model.Patient;
import com.mrodriguezul.citasapp.persistence.entity.PatientEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PersonPersistenceMapper.class, IdentificationPersistenceMapper.class})
public interface PatientPersistenceMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "personEntity.identificationEntity", target = "identificacion"),
        @Mapping(source = "personEntity.identificationNumber", target = "numeroIdentificacion"),
        @Mapping(source = "personEntity.names", target = "nombres"),
        @Mapping(source = "personEntity.surnames", target = "apellidos"),
        @Mapping(source = "personEntity.dateOfBirth", target = "fechaNacimiento"),
        @Mapping(source = "personEntity.email", target = "email"),
        @Mapping(source = "personEntity.phoneNumber", target = "numeroTelefono")
    })
    Patient toPaciente(PatientEntity patientEntity);

    @InheritConfiguration
    @Mappings({
            @Mapping(source = "id", target = "personEntity.id"),
            @Mapping(target = "appointments", ignore = true)
    })
    PatientEntity toPatientEntity(Patient patient);
}

