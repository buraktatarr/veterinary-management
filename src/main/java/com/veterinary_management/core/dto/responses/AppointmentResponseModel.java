package com.veterinary_management.core.dto.responses;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AppointmentResponseModel(
		Long id,
		LocalDateTime appointmentDate,
		String animalName,
		String doctorName
) {
}

