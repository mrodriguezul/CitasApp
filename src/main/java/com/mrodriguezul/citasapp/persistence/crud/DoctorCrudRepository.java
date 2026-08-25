package com.mrodriguezul.citasapp.persistence.crud;

import com.mrodriguezul.citasapp.persistence.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorCrudRepository extends JpaRepository<DoctorEntity, Long> {
    List<DoctorEntity> findAllByOrderByIdAsc();
    List<DoctorEntity> findAllByPersonEntity_namesContainingIgnoreCaseOrPersonEntity_surnamesContainingIgnoreCaseOrderByIdAsc(String names, String surnames);
    List<DoctorEntity> findAllBySpecialityEntity_IdOrderByIdAsc(Long specialityId);
    List<DoctorEntity> findAllBySpecialityEntity_IdInOrderByIdAsc(List<Long> specialityIds);
    Optional<DoctorEntity> findByPersonEntity_IdentificationNumberOrderByIdAsc(String identificationNumber);
    Optional<DoctorEntity> findByPersonEntity_IdentificationEntityIdAndPersonEntity_IdentificationNumber(Long identificationId, String identificationNumber);
    int countAllBySpecialityEntity_Id(Long specialityId);
    int countAllByPersonEntity_IdentificationEntityId(Long identificationId);
}