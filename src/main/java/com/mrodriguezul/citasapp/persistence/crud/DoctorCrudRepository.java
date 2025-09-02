package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorCrudRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllByOrderByIdAsc();
    List<Doctor> findAllByPerson_namesContainingIgnoreCaseOrPerson_surnamesContainingIgnoreCaseOrderByIdAsc(String names, String surnames);
    List<Doctor> findAllBySpeciality_IdOrderByIdAsc(Long specialityId);
    Optional<Doctor> findByPerson_IdentificationNumberOrderByIdAsc(String identificationNumber);
    Optional<Doctor> findByPerson_IdentificationIdAndPerson_IdentificationNumber(Long identificationId, String identificationNumber);
}