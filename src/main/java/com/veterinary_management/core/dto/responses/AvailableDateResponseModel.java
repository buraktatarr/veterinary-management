package com.veterinary_management.core.dto.responses;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AvailableDateResponseModel(
		Long id,
		Long doctorId,
		LocalDate availableDate)
{ }