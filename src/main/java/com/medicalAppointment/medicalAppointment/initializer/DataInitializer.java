package com.medicalAppointment.medicalAppointment;

import com.medicalAppointment.medicalAppointment.model.Doctor;
import com.medicalAppointment.medicalAppointment.model.Consultorio;
import com.medicalAppointment.medicalAppointment.repository.DoctorRepository;
import com.medicalAppointment.medicalAppointment.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @Override
    public void run(String... args) throws Exception {
        Doctor doctor1 = new Doctor("Juan", "Perez", "Lopez", "Medicina Interna");
        Doctor doctor2 = new Doctor("Maria", "Gonzalez", "Hernandez", "Cardiología");
        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);

        Consultorio consultorio1 = new Consultorio(101, 1);
        Consultorio consultorio2 = new Consultorio(102, 2);
        consultorioRepository.save(consultorio1);
        consultorioRepository.save(consultorio2);
    }
}
