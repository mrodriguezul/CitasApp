package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorCrudRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpeciality_IdOrderBySpeciality_Id(Long id);
    Optional<Doctor> findByPerson_Id(Long personId);
    Optional<Doctor> findByPerson_IdAndPerson_IdentificationNumber(Long personId, String identificationNumber);
    Optional<Doctor> findByPerson_IdentificationIdAndPerson_IdentificationNumber(Long identificationId, String identificationNumber);

}
