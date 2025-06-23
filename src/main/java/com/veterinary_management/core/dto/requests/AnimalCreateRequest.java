package com.veterinary_management.core.dto.requests;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AnimalCreateRequest(
		String name,
		String species,
		String breed,
		String gender,
		String colour,
		LocalDate dateOfBirth,
		Long customerId
) {
}
