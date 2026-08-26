package com.mrodriguezul.citasapp.domain.model;

public class Speciality {
    private Long id;
    private String nombre;

    public Speciality(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Speciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
