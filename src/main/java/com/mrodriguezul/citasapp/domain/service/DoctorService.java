package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.Doctor;
import com.mrodriguezul.citasapp.domain.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctor(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public boolean delete(Long id) {
        return getDoctor(id).map(doctor -> {
            doctorRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
