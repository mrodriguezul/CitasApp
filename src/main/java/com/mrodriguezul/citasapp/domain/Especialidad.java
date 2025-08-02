package com.mrodriguezul.citasapp.domain;

public class Especialidad {
    private Long id;
    private String nombre;

    public Especialidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Especialidad() {
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
