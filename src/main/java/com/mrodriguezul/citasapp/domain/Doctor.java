package com.mrodriguezul.citasapp.domain;

public class Doctor extends Persona {
    private Especialidad especialidad;

    public Doctor(Long id, Especialidad especialidad) {
        super(id);
        this.especialidad = especialidad;
    }

    public Doctor() {
        super();
    }

    // Business logic methods
    public boolean puedeAtenderEspecialidad(Especialidad especialidadSolicitada) {
        return this.especialidad != null && this.especialidad.equals(especialidadSolicitada);
    }

    public boolean esDoctor() {
        return especialidad != null;
    }

    public String getNombreConEspecialidad() {
        String nombre = getNombreCompleto();
        if (especialidad != null && especialidad.getNombre() != null) {
            return "Dr. " + nombre + " - " + especialidad.getNombre();
        }
        return "Dr. " + nombre;
    }

    @Override
    public void validarDatos() {
        super.validarDatos(); // Validar datos de Persona
        if (especialidad == null) {
            throw new IllegalArgumentException("El doctor debe tener una especialidad asignada");
        }
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
