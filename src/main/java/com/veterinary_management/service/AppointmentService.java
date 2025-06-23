package com.veterinary_management.service;

import com.veterinary_management.core.dto.requests.AppointmentCreateRequest;
import com.veterinary_management.core.dto.requests.AppointmentUpdateRequest;
import com.veterinary_management.core.dto.responses.AppointmentResponseModel;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
	void save(AppointmentCreateRequest request);

	void update(AppointmentUpdateRequest request);

	void deleteById(Long id);

	List<AppointmentResponseModel> findAll();

	List<AppointmentResponseModel> findByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end);

	List<AppointmentResponseModel> findByAnimalAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end);
}
