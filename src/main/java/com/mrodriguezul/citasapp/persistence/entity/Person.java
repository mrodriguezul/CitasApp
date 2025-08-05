package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "identification_id", nullable = false)
    private Identification identification;

    @Column(name = "identification_number", nullable = false, length = 20)
    private String identificationNumber;

    @Column(nullable = false, length = 30)
    private String names;

    @Column(length = 40)
    private String surnames;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(length = 20)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    @OneToOne(mappedBy = "person")
    private Doctor doctor;

    @OneToOne(mappedBy = "person")
    private Patient patient;

    // Constructores
    public Person() {}

    public Person(Long id, Identification identification, String identificationNumber, String names, String surnames, Date dateOfBirth, String email, String phoneNumber) {
        this.id = id;
        this.identification = identification;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.surnames = surnames;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Identification getIdentification() { return identification; }
    public void setIdentification(Identification identification) { this.identification = identification; }
    public String getIdentificationNumber() { return identificationNumber; }
    public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber;}
    public String getNames() { return names; }
    public void setNames(String names) { this.names = names; }
    public String getSurnames() { return surnames; }
    public void setSurnames(String surnames) { this.surnames = surnames; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
