package com.veterinary_management.core.dto.requests;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AvailableDateUpdateRequest(
		Long id,
		Long doctorId,
		LocalDate availableDate
) {
}
