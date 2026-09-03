package com.mrodriguezul.apptapp.persistence.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IdentificationPersistenceMapper.class})
public interface PersonPersistenceMapper {
    // Define mapping methods here if needed
    // For example, you can map between domain and entity classes related to Person
     /*@Mappings({
         @Mapping(source = "id", target = "idPersona"),
         @Mapping(source = "identification", target = "identificacion"),
         @Mapping(source = "identificationNumber", target = "numeroIdentificacion"),
         @Mapping(source = "names", target = "nombres"),
         @Mapping(source = "surnames", target = "apellidos"),
         @Mapping(source = "dateOfBirth", target = "fechaNacimiento"),
         @Mapping(source = "email", target = "email"),
         @Mapping(source = "phoneNumber", target = "numeroTelefono")
     })
     Person toPersona(PersonEntity person);
     List<Person> toPersonas(List<PersonEntity> persons);

     @InheritInverseConfiguration
     @Mappings({
         @Mapping(target = "doctor", ignore = true),
         @Mapping(target = "patient", ignore = true)
     })
     PersonEntity toPerson(Person persona);*/


}
