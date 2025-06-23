package com.veterinary_management.service;

import com.veterinary_management.core.dto.requests.DoctorCreateRequest;
import com.veterinary_management.core.dto.requests.DoctorUpdateRequest;
import com.veterinary_management.core.dto.responses.DoctorResponseModel;

import java.util.List;

public interface DoctorService {
	void save(DoctorCreateRequest request);

	void update(DoctorUpdateRequest request);

	void delete(Long id);

	List<DoctorResponseModel> findAll();

	DoctorResponseModel findById(Long id);
}

