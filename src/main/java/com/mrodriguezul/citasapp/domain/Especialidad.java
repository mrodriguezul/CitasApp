package com.mrodriguezul.citasapp.domain;

import java.util.Objects;

public class Especialidad {
    private Long id;
    private String nombre;

    public Especialidad(Long id, String nombre) {
        this.id = id;
        setNombre(nombre);
    }

    public Especialidad() {
    }

    // Business logic methods
    public boolean esValida() {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public void validarDatos() {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la especialidad es obligatorio");
        }
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
        if (nombre != null) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = nombre;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especialidad that = (Especialidad) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
