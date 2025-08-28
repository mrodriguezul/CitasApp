package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    // Constructores
    public Patient() {}

    public Patient(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
    public List<Appointment> getAppointments() { return appointments; }
    public void setAppointments(List<Appointment> appointments) { this.appointments = appointments; }
}

