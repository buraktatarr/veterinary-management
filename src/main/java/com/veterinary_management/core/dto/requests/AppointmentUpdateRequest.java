package com.veterinary_management.core.dto.requests;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AppointmentUpdateRequest(
		Long id,
		LocalDateTime appointmentDate,
		Long animalId,
		Long doctorId
) {
}
