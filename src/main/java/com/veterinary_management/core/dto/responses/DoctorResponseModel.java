package com.veterinary_management.core.dto.responses;

import lombok.Builder;

import java.util.List;

@Builder
public record DoctorResponseModel(
		Long id,
		String name,
		String phone,
		String mail,
		String address,
		String city,
		List<AvailableDateResponseModel> availableDates
) {}
