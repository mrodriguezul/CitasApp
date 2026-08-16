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
public class Doctor implements Serializable {
    @Id
    private Long id;

    @OneToOne(fetch =  FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    @OrderBy("appointmentDate DESC")
    private List<Appointment> appointments;
}