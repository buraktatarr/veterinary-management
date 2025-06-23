package com.veterinary_management.core.dto.requests;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record VaccineUpdateRequest(
		Long id,
		String name,
		String code,
		LocalDate protectionStartDate,
		LocalDate protectionFinishDate,
		Long animalId
) { }
