package com.veterinary_management.service.impl;

import com.veterinary_management.core.dto.requests.AppointmentCreateRequest;
import com.veterinary_management.core.dto.requests.AppointmentUpdateRequest;
import com.veterinary_management.core.dto.responses.AppointmentResponseModel;
import com.veterinary_management.entity.Animal;
import com.veterinary_management.entity.Appointment;
import com.veterinary_management.entity.Doctor;
import com.veterinary_management.repository.AnimalRepository;
import com.veterinary_management.repository.AppointmentRepository;
import com.veterinary_management.repository.AvailableDateRepository;
import com.veterinary_management.repository.DoctorRepository;
import com.veterinary_management.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
	private final AppointmentRepository   appointmentRepository;
	private final AnimalRepository        animalRepository;
	private final DoctorRepository        doctorRepository;
	private final AvailableDateRepository availableDateRepository;

	@Override
	public void save(AppointmentCreateRequest request) {
		LocalDate date = request.appointmentDate().toLocalDate();
		boolean doctorAvailable = availableDateRepository.existsByDoctorIdAndAvailableDate(request.doctorId(), date);
		if (!doctorAvailable) {
			throw new RuntimeException("Doktor bu tarihte çalışmamaktadır!");
		}
		boolean alreadyExists = appointmentRepository.existsByDoctorIdAndAppointmentDate(request.doctorId(), request.appointmentDate());
		if (alreadyExists) {
			throw new RuntimeException("Girilen saatte başka bir randevu mevcuttur.");
		}
		Animal animal = animalRepository.findById(request.animalId())
				.orElseThrow(() -> new RuntimeException("Hayvan bulunamadı."));
		Doctor doctor = doctorRepository.findById(request.doctorId())
				.orElseThrow(() -> new RuntimeException("Doktor bulunamadı."));
		Appointment appointment = Appointment.builder()
				.appointmentDate(request.appointmentDate())
				.animal(animal)
				.doctor(doctor)
				.build();
		appointmentRepository.save(appointment);
	}

	@Override
	public void update(AppointmentUpdateRequest request) {
		Appointment appointment = appointmentRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Randevu bulunamadı."));
		Animal animal = animalRepository.findById(request.animalId())
				.orElseThrow(() -> new RuntimeException("Hayvan bulunamadı."));
		Doctor doctor = doctorRepository.findById(request.doctorId())
				.orElseThrow(() -> new RuntimeException("Doktor bulunamadı."));
		appointment.setAppointmentDate(request.appointmentDate());
		appointment.setAnimal(animal);
		appointment.setDoctor(doctor);
		appointmentRepository.save(appointment);
	}

	@Override
	public void deleteById(Long id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public List<AppointmentResponseModel> findAll() {
		return appointmentRepository.findAll().stream().map(app ->
				AppointmentResponseModel.builder()
						.id(app.getId())
						.appointmentDate(app.getAppointmentDate())
						.animalName(app.getAnimal().getName())
						.doctorName(app.getDoctor().getName())
						.build()
		).toList();
	}

	@Override
	public List<AppointmentResponseModel> findByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end) {
		return appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, start, end)
				.stream().map(app ->
						AppointmentResponseModel.builder()
								.id(app.getId())
								.appointmentDate(app.getAppointmentDate())
								.animalName(app.getAnimal().getName())
								.doctorName(app.getDoctor().getName())
								.build())
				.toList();
	}

	@Override
	public List<AppointmentResponseModel> findByAnimalAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end) {
		return appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, start, end)
				.stream().map(app ->
						AppointmentResponseModel.builder()
								.id(app.getId())
								.appointmentDate(app.getAppointmentDate())
								.animalName(app.getAnimal().getName())
								.doctorName(app.getDoctor().getName())
								.build())
				.toList();
	}
}
