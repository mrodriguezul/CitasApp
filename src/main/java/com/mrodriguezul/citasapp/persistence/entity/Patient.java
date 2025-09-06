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
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @OrderBy("appointmentDate DESC")
    private List<Appointment> appointments;
}
