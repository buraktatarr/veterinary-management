package com.veterinary_management.service;

import com.veterinary_management.core.dto.requests.AnimalCreateRequest;
import com.veterinary_management.core.dto.responses.AnimalResponseModel;
import com.veterinary_management.core.dto.requests.AnimalUpdateRequest;

import java.util.List;

public interface AnimalService {
	void save(AnimalCreateRequest request);

	void update(AnimalUpdateRequest request);

	void deleteById(Long id);

	List<AnimalResponseModel> findAll();

	List<AnimalResponseModel> findByName(String name);

	List<AnimalResponseModel> findByCustomerId(Long customerId);
}
