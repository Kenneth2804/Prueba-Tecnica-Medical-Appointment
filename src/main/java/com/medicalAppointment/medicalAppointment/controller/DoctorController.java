package com.medicalAppointment.medicalAppointment.controller;

import com.medicalAppointment.medicalAppointment.model.Doctor;
import com.medicalAppointment.medicalAppointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> obtenerDoctores() {
        return doctorRepository.findAll();
    }

    @PostMapping
    public Doctor crearDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}

