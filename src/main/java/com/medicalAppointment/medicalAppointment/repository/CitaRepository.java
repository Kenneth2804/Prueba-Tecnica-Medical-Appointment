package com.medicalAppointment.medicalAppointment.repository;

import com.medicalAppointment.medicalAppointment.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import com.medicalAppointment.medicalAppointment.model.Doctor;
import com.medicalAppointment.medicalAppointment.model.Consultorio;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    boolean existsByConsultorioAndHorarioConsulta(Consultorio consultorio, LocalDateTime horarioConsulta);
    boolean existsByDoctorAndHorarioConsulta(Doctor doctor, LocalDateTime horarioConsulta);
    boolean existsByPacienteNombreAndHorarioConsultaBetween(String pacienteNombre, LocalDateTime inicio, LocalDateTime fin);
    long countByDoctorAndHorarioConsultaBetween(Doctor doctor, LocalDateTime inicio, LocalDateTime fin);

    List<Cita> findByDoctorAndHorarioConsultaBetween(Doctor doctor, LocalDateTime inicio, LocalDateTime fin);
    List<Cita> findByConsultorioAndHorarioConsultaBetween(Consultorio consultorio, LocalDateTime inicio, LocalDateTime fin);
    List<Cita> findByHorarioConsultaBetween(LocalDateTime inicio, LocalDateTime fin);
}
