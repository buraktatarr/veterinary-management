package com.veterinary_management.api;

import com.veterinary_management.core.dto.requests.AppointmentCreateRequest;
import com.veterinary_management.core.dto.requests.AppointmentUpdateRequest;
import com.veterinary_management.core.dto.responses.AppointmentResponseModel;
import com.veterinary_management.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointment")
public class AppointmentsApi {

	private final AppointmentService service;

	@PostMapping
	public void create(@RequestBody AppointmentCreateRequest request) {
		service.save(request);
	}

	@PutMapping
	public void update(@RequestBody AppointmentUpdateRequest request) {
		service.update(request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping
	public List<AppointmentResponseModel> getAll() {
		return service.findAll();
	}

	@GetMapping("/doctor")
	public List<AppointmentResponseModel> getByDoctor(
			@RequestParam Long doctorId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
		return service.findByDoctorAndDateRange(doctorId, start, end);
	}

	@GetMapping("/animal")
	public List<AppointmentResponseModel> getByAnimal(
			@RequestParam Long animalId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
		return service.findByAnimalAndDateRange(animalId, start, end);
	}
}

