package com.veterinary_management.repository;

import com.veterinary_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDateTime start, LocalDateTime end);

	List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);

	boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime dateTime);
}
