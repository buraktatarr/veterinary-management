package com.veterinary_management.core.dto.responses;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record VaccineResponseModel(
		String name,
		String code,
		LocalDate protectionStartDate,
		LocalDate protectionFinishDate,
		AnimalResponseModel animal
) {
}
