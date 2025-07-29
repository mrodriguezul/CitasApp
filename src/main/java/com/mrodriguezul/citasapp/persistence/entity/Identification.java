package com.mrodriguezul.citasapp.persistence.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "identification")
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 40)
    private String description;

    @OneToMany(mappedBy = "identification")
    private List<Person> persons;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Person> getPersons() { return persons; }
    public void setPersons(List<Person> persons) { this.persons = persons; }
}

