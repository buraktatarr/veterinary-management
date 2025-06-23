package com.veterinary_management.core.dto.requests;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AvailableDateCreateRequest(
		Long doctorId,
		LocalDate availableDate) {
}
