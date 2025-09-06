package com.mrodriguezul.citasapp.persistence.entity;

import com.mrodriguezul.citasapp.persistence.audit.AuditEntity;
import com.mrodriguezul.citasapp.persistence.audit.AuditPersonListener;
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
@Table(name = "person")
@EntityListeners(AuditPersonListener.class)
public class Person extends AuditEntity implements Serializable {
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

    @Column(length = 30)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identification_id", nullable = false)
    private Identification identification;

    @OneToOne(mappedBy = "person")
    private Doctor doctor;

    @OneToOne(mappedBy = "person")
    private Patient patient;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", names='" + names + '\'' +
                ", surnames='" + surnames + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", identification=" + (identification != null ? identification.getId() : null) +
                '}';
    }
}
