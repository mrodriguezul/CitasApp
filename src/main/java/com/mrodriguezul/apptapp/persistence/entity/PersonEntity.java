package com.mrodriguezul.apptapp.persistence.entity;

import com.mrodriguezul.apptapp.persistence.audit.AuditEntity;
import com.mrodriguezul.apptapp.persistence.audit.AuditPersonListener;
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
public class PersonEntity extends AuditEntity implements Serializable {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identification_id", nullable = false)
    private IdentificationEntity identificationEntity;

    @OneToOne(mappedBy = "personEntity")
    private DoctorEntity doctorEntity;

    @OneToOne(mappedBy = "personEntity")
    private PatientEntity patientEntity;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", names='" + names + '\'' +
                ", surnames='" + surnames + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", identificationEntity=" + (identificationEntity != null ? identificationEntity.getId() : null) +
                '}';
    }
}
