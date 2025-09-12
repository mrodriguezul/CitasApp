package com.mrodriguezul.citasapp.domain;

import java.time.LocalDateTime;

public class Rol {
    private String nombre;
    private LocalDateTime fechaAsignacion;

    public Rol() {
    }

    public Rol(String nombre, LocalDateTime fechaAsignacion) {
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
        return "Rol{" +
                "nombre='" + nombre + '\'' +
                ", fechaAsignacion=" + fechaAsignacion +
                '}';
    }
}
