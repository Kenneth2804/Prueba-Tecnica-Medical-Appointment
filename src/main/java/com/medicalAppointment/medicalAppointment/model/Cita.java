package com.medicalAppointment.medicalAppointment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "consultorio_id")
    private Consultorio consultorio;

    @Column(name = "horario_consulta")
    private LocalDateTime horarioConsulta;

    @Column(name = "paciente_nombre")
    private String pacienteNombre;

    // Constructor vacío
    public Cita() {}

    // Constructor con parámetros
    public Cita(Doctor doctor, Consultorio consultorio, LocalDateTime horarioConsulta, String pacienteNombre) {
        this.doctor = doctor;
        this.consultorio = consultorio;
        this.horarioConsulta = horarioConsulta;
        this.pacienteNombre = pacienteNombre;
    }
}
