package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false, nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "speciality_id", insertable = false, updatable = false, nullable = false)
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    // Constructores
    public Doctor() {}

    public Doctor(Long id, Person person, Speciality speciality) {
        this.id = id;
        this.person = person;
        this.speciality = speciality;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
    public Speciality getSpeciality() { return speciality; }
    public void setSpeciality(Speciality speciality) { this.speciality = speciality; }
    public List<Appointment> getAppointments() { return appointments; }
    public void setAppointments(List<Appointment> appointments) { this.appointments = appointments; }
}

