package com.veterinary_management.core.dto.responses;

import lombok.Builder;

import java.util.List;

@Builder
public record CustomerResponseModel(
		String name,
		String phone,
		String mail,
		String address,
		String city,
		List<AnimalResponseModel> animalResponseModels
) {
}
