package com.mrodriguezul.apptapp.domain.model;

public class Doctor extends Person {
    private Speciality speciality;

    public Doctor(Long id, Speciality speciality) {
        super(id);
        this.speciality = speciality;
    }

    public Doctor() {
        super();
    }

    public void setEspecialidad(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getEspecialidad() {
        return speciality;
    }

}
