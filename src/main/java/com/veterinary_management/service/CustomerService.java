package com.veterinary_management.service;

import com.veterinary_management.core.dto.requests.CustomerCreateRequest;
import com.veterinary_management.core.dto.requests.CustomerUpdateRequest;
import com.veterinary_management.core.dto.responses.CustomerResponseModel;

import java.util.List;

public interface CustomerService {
	void save(CustomerCreateRequest request);

	void update(CustomerUpdateRequest request);

	void delete(Long id);

	List<CustomerResponseModel> findAll();

	List<CustomerResponseModel> findByName(String name);
}
