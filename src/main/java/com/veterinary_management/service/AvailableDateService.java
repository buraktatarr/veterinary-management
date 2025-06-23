package com.veterinary_management.service;

import com.veterinary_management.core.dto.requests.AvailableDateCreateRequest;
import com.veterinary_management.core.dto.requests.AvailableDateUpdateRequest;
import com.veterinary_management.core.dto.responses.AvailableDateResponseModel;

import java.util.List;

public interface AvailableDateService {
	void save(AvailableDateCreateRequest request);

	void update(AvailableDateUpdateRequest request);

	void deleteById(Long id);

	List<AvailableDateResponseModel> findByDoctorId(Long doctorId);
}
