package com.veterinary_management.service.impl;

import com.veterinary_management.core.dto.requests.CustomerCreateRequest;
import com.veterinary_management.core.dto.requests.CustomerUpdateRequest;
import com.veterinary_management.core.dto.responses.AnimalResponseModel;
import com.veterinary_management.core.dto.responses.CustomerResponseModel;
import com.veterinary_management.entity.Customer;
import com.veterinary_management.repository.CustomerRepository;
import com.veterinary_management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	public void save(CustomerCreateRequest request) {
		Customer customer = Customer.builder()
				.name(request.name())
				.phone(request.phone())
				.address(request.address())
				.mail(request.mail())
				.city(request.city())
				.build();
		customerRepository.save(customer);
	}

	@Override
	public void update(CustomerUpdateRequest request) {
		Customer customer = Customer.builder()
				.id(request.id())
				.name(request.name())
				.phone(request.phone())
				.address(request.address())
				.mail(request.mail())
				.city(request.city())
				.build();
		customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public List<CustomerResponseModel> findAll() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> CustomerResponseModel.builder()
				.name(customer.getName())
				.phone(customer.getPhone())
				.mail(customer.getMail())
				.address(customer.getAddress())
				.city(customer.getCity())
				.animalResponseModels(
						customer.getAnimals().stream()
								.map(animal -> AnimalResponseModel.builder()
										.name(animal.getName())
										.species(animal.getSpecies())
										.breed(animal.getBreed())
										.gender(animal.getGender())
										.colour(animal.getColour())
										.dateOfBirth(animal.getDateOfBirth())
										.build())
								.toList()
				)
				.build()
		).toList();
	}

	@Override
	public List<CustomerResponseModel> findByName(String name) {
		return customerRepository.findByNameContainingIgnoreCase(name).stream().map(customer -> CustomerResponseModel.builder()
				.name(customer.getName())
				.phone(customer.getPhone())
				.mail(customer.getMail())
				.address(customer.getAddress())
				.city(customer.getCity())
				.animalResponseModels(
						customer.getAnimals().stream()
								.map(animal -> AnimalResponseModel.builder()
										.name(animal.getName())
										.species(animal.getSpecies())
										.breed(animal.getBreed())
										.gender(animal.getGender())
										.colour(animal.getColour())
										.dateOfBirth(animal.getDateOfBirth())
										.build())
								.toList()
				)
				.build()
		).toList();
	}
}
