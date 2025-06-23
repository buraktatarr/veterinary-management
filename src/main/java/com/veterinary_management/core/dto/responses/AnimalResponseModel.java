package com.veterinary_management.core.dto.responses;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AnimalResponseModel(
		String name,
		String species,
		String breed,
		String gender,
		String colour,
		LocalDate dateOfBirth
) {
}
