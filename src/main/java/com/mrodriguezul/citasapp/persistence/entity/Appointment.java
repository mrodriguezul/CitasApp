package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
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

    // Constructores
    public Appointment() {}

    public Appointment(Long id, Doctor doctor, Patient patient, Date appointmentDate, String reason) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}

