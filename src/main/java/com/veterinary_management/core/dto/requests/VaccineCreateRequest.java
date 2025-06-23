package com.veterinary_management.core.dto.requests;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record VaccineCreateRequest(
		String name,
		String code,
		LocalDate protectionStartDate,
		LocalDate protectionFinishDate,
		Long animalId
) {
}
