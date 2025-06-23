package com.veterinary_management.core.dto.requests;

import java.time.LocalDateTime;

public record AppointmentCreateRequest(
		LocalDateTime appointmentDate,
		Long animalId,
		Long doctorId
) {}
