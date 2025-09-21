package com.mrodriguezul.citasapp.domain;

import java.util.Objects;

public class Identificacion {
    private Long idIdentificacion;
    private String nombre;
    private String descripcion;

    public Identificacion() {
    }

    public Identificacion(Long idIdentificacion, String nombre, String descripcion) {
        this.idIdentificacion = idIdentificacion;
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    // Business logic methods
    public boolean esValida() {
        return nombre != null && !nombre.trim().isEmpty() &&
               descripcion != null && !descripcion.trim().isEmpty();
    }

    public void validarDatos() {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tipo de identificación es obligatorio");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del tipo de identificación es obligatoria");
        }
    }

    // Getters and Setters
    public Long getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(Long idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        } else {
            this.descripcion = descripcion;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identificacion that = (Identificacion) o;
        return Objects.equals(idIdentificacion, that.idIdentificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIdentificacion);
    }

    @Override
    public String toString() {
        return "Identificacion{" +
                "idIdentificacion=" + idIdentificacion +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
