package com.veterinary_management.service;

import com.veterinary_management.core.dto.requests.VaccineCreateRequest;
import com.veterinary_management.core.dto.requests.VaccineUpdateRequest;
import com.veterinary_management.core.dto.responses.VaccineResponseModel;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
	void save(VaccineCreateRequest request);

	void save(VaccineUpdateRequest request);

	void deleteById(Long id);

	List<VaccineResponseModel> findAll();

	List<VaccineResponseModel> findByAnimalId(Long animalId);

	List<VaccineResponseModel> findVaccinesExpiringBetween(LocalDate start, LocalDate end);
}
