package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctor")
public class DoctorEntity implements Serializable {
    @Id
    private Long id;

    @OneToOne(fetch =  FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private PersonEntity personEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false)
    private SpecialityEntity specialityEntity;

    @OneToMany(mappedBy = "doctorEntity", fetch = FetchType.LAZY)
    @OrderBy("appointmentDate DESC")
    private List<AppointmentEntity> appointments;
}