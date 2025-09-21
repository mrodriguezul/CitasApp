package com.mrodriguezul.citasapp.domain;

public class Paciente extends Persona{

    public Paciente(Long id) {
        super(id);
    }

    public Paciente() {
        super();
    }

    // Business logic methods
    public boolean puedeAgendarCita() {
        return esMayorDeEdad() || tieneResponsableLegal();
    }

    public boolean tieneResponsableLegal() {
        // En una implementación real, esto podría verificar si el paciente menor
        // tiene un responsable legal registrado
        return !esMayorDeEdad(); // Placeholder logic
    }

    public String getTipoPaciente() {
        if (esMayorDeEdad()) {
            return "Adulto";
        } else if (getEdad() >= 12) {
            return "Adolescente";
        } else if (getEdad() >= 2) {
            return "Niño";
        } else {
            return "Bebé";
        }
    }

    @Override
    public void validarDatos() {
        super.validarDatos(); // Validar datos de Persona
        // Validaciones adicionales específicas para pacientes si las hubiera
    }
}
