package com.mrodriguezul.citasapp.domain;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class Persona {

    private Long id;
    private Identificacion identificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String email;
    private String numeroTelefono;

    public Persona(Long id) {
        this.id = id;
    }

    public Persona() {
    }

    // Business logic methods
    public String getNombreCompleto() {
        if (nombres == null && apellidos == null) {
            return "";
        }
        if (nombres == null) {
            return apellidos;
        }
        if (apellidos == null) {
            return nombres;
        }
        return nombres + " " + apellidos;
    }

    public int getEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        LocalDate fechaNac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

    public boolean esMayorDeEdad() {
        return getEdad() >= 18;
    }

    public boolean esEmailValido() {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public void validarDatos() {
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }
        if (apellidos == null || apellidos.trim().isEmpty()) {
            throw new IllegalArgumentException("Los apellidos son obligatorios");
        }
        if (numeroIdentificacion == null || numeroIdentificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de identificación es obligatorio");
        }
        if (identificacion == null) {
            throw new IllegalArgumentException("El tipo de identificación es obligatorio");
        }
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }
        if (email != null && !esEmailValido()) {
            throw new IllegalArgumentException("El formato del email es inválido");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
