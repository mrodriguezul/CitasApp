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
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "identification_id", nullable = false)
    private Identification identification;

    @OneToOne(mappedBy = "person")
    private Doctor doctor;

    @OneToOne(mappedBy = "person")
    private Patient patient;
}
