package com.medicalAppointment.medicalAppointment.repository;

import com.medicalAppointment.medicalAppointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
