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

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

}
