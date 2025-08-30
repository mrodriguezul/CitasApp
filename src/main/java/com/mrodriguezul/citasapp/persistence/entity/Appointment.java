package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false, nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false, nullable = false)
    private Patient patient;

    @Column(name = "appointment_date", nullable = false)
    private Date appointmentDate;

    @Column(nullable = false, columnDefinition = "text")
    private String reason;
}

