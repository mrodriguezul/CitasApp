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
@Table(name = "patient")
public class Patient {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}

