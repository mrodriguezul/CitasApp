package com.mrodriguezul.apptapp.domain.model;

import java.time.LocalDateTime;

public class Role {
    private String nombre;
    private LocalDateTime fechaAsignacion;

    public Role() {
    }

    public Role(String nombre, LocalDateTime fechaAsignacion) {
        this.nombre = nombre;
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Override
    public String toString() {
        return "Role{" +
                "nombre='" + nombre + '\'' +
                ", fechaAsignacion=" + fechaAsignacion +
                '}';
    }
}
