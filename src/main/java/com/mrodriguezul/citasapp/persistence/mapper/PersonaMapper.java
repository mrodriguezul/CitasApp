package com.mrodriguezul.citasapp.persistence.mapper;

import com.mrodriguezul.citasapp.domain.Persona;
import com.mrodriguezul.citasapp.persistence.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IdentificacionMapper.class})
public interface PersonaMapper {
    // Define mapping methods here if needed
    // For example, you can map between domain and entity classes related to Persona
     @Mappings({
         @Mapping(source = "id", target = "idPersona"),
         @Mapping(source = "identification", target = "identificacion"),
         @Mapping(source = "identificationNumber", target = "numeroIdentificacion"),
         @Mapping(source = "names", target = "nombres"),
         @Mapping(source = "surnames", target = "apellidos"),
         @Mapping(source = "dateOfBirth", target = "fechaNacimiento"),
         @Mapping(source = "email", target = "email"),
         @Mapping(source = "phoneNumber", target = "numeroTelefono")
     })
     Persona toPersona(Person person);
     List<Persona> toPersonas(List<Person> persons);

     @InheritInverseConfiguration
     @Mappings({
         @Mapping(target = "doctors", ignore = true),
         @Mapping(target = "patients", ignore = true)
     })
     Person toPerson(Persona persona);

}
