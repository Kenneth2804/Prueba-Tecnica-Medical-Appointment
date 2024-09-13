package com.medicalAppointment.medicalAppointment.controller;

import com.medicalAppointment.medicalAppointment.model.Cita;
import com.medicalAppointment.medicalAppointment.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        try {
            Cita nuevaCita = citaService.crearCita(cita);
            return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cita>> obtenerCitas() {
        try {
            List<Cita> citas = citaService.obtenerCitas();
            return new ResponseEntity<>(citas, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCita(@PathVariable Long id) {
        try {
            Cita cita = citaService.obtenerCitaPorId(id);
            return cita != null ? new ResponseEntity<>(cita, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@PutMapping("/{id}")
public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
    try {
        Cita citaActualizada = citaService.actualizarCita(id, cita);
        return new ResponseEntity<>(citaActualizada, HttpStatus.OK);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        try {
            citaService.eliminarCita(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
