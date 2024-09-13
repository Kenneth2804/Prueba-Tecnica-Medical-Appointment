package com.medicalAppointment.medicalAppointment.controller;

import com.medicalAppointment.medicalAppointment.model.Consultorio;
import com.medicalAppointment.medicalAppointment.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @GetMapping
    public List<Consultorio> obtenerConsultorios() {
        return consultorioRepository.findAll();
    }

    @PostMapping
    public Consultorio crearConsultorio(@RequestBody Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }
}

