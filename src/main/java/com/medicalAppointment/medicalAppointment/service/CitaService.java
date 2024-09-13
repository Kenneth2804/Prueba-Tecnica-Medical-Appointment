package com.medicalAppointment.medicalAppointment.service;

import com.medicalAppointment.medicalAppointment.model.Cita;
import com.medicalAppointment.medicalAppointment.repository.CitaRepository;
import com.medicalAppointment.medicalAppointment.repository.DoctorRepository;
import com.medicalAppointment.medicalAppointment.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultorioRepository consultorioRepository;

    public Cita crearCita(Cita cita) {
        // Validar que el doctor y el consultorio existen
        if (!doctorRepository.existsById(cita.getDoctor().getId())) {
            throw new RuntimeException("El doctor no existe.");
        }

        if (!consultorioRepository.existsById(cita.getConsultorio().getId())) {
            throw new RuntimeException("El consultorio no existe.");
        }

        // Verificar reglas de negocio
        if (citaRepository.existsByConsultorioAndHorarioConsulta(cita.getConsultorio(), cita.getHorarioConsulta())) {
            throw new RuntimeException("El consultorio ya tiene una cita a esta hora.");
        }

        if (citaRepository.existsByDoctorAndHorarioConsulta(cita.getDoctor(), cita.getHorarioConsulta())) {
            throw new RuntimeException("El doctor ya tiene una cita a esta hora.");
        }

        if (citaRepository.existsByPacienteNombreAndHorarioConsultaBetween(cita.getPacienteNombre(), cita.getHorarioConsulta().toLocalDate().atStartOfDay(), cita.getHorarioConsulta().toLocalDate().plusDays(1).atStartOfDay())) {
            throw new RuntimeException("El paciente ya tiene una cita en el mismo día.");
        }

        long citasDelDoctor = citaRepository.countByDoctorAndHorarioConsultaBetween(cita.getDoctor(), cita.getHorarioConsulta().toLocalDate().atStartOfDay(), cita.getHorarioConsulta().toLocalDate().plusDays(1).atStartOfDay());
        if (citasDelDoctor >= 8) {
            throw new RuntimeException("El doctor no puede tener más de 8 citas en el día.");
        }

        // Guardar la cita
        return citaRepository.save(cita);
    }

    // Nuevo método para obtener todas las citas
    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }

    public Cita obtenerCitaPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

public Cita actualizarCita(Long id, Cita cita) {
    if (!citaRepository.existsById(id)) {
        throw new RuntimeException("La cita no existe.");
    }
    cita.setId(id);

    return citaRepository.save(cita);
}



    public void eliminarCita(Long id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }
}
