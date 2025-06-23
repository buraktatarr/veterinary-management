package com.veterinary_management.service.impl;

import com.veterinary_management.core.dto.requests.AnimalCreateRequest;
import com.veterinary_management.core.dto.requests.AnimalUpdateRequest;
import com.veterinary_management.core.dto.responses.AnimalResponseModel;
import com.veterinary_management.entity.Animal;
import com.veterinary_management.repository.AnimalRepository;
import com.veterinary_management.repository.CustomerRepository;
import com.veterinary_management.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

	private final AnimalRepository   animalRepository;
	private final CustomerRepository customerRepository;

	@Override
	public void save(AnimalCreateRequest request) {
		var customer = customerRepository.findById(request.customerId())
				.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + request.customerId()));

		Animal animal = Animal.builder()
				.name(request.name())
				.species(request.species())
				.breed(request.breed())
				.gender(request.gender())
				.colour(request.colour())
				.dateOfBirth(request.dateOfBirth())
				.customer(customer)
				.build();

		animalRepository.save(animal);
	}

	@Override
	public void update(AnimalUpdateRequest request) {
		var animal = animalRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Animal not found with ID: " + request.id()));

		animal.setName(request.name());
		animal.setSpecies(request.species());
		animal.setBreed(request.breed());
		animal.setGender(request.gender());
		animal.setColour(request.colour());
		animal.setDateOfBirth(request.dateOfBirth());

		animalRepository.save(animal);
	}

	@Override
	public void deleteById(Long id) {
		var animal = animalRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Animal not found with ID: " + id));
		animalRepository.delete(animal);
	}

	@Override
	public List<AnimalResponseModel> findAll() {
		return animalRepository.findAll().stream()
				.map(animal -> AnimalResponseModel.builder()
						.name(animal.getName())
						.species(animal.getSpecies())
						.breed(animal.getBreed())
						.gender(animal.getGender())
						.colour(animal.getColour())
						.dateOfBirth(animal.getDateOfBirth())
						.build())
				.toList();
	}

	@Override
	public List<AnimalResponseModel> findByName(String name) {
		return  animalRepository.findByName(name).stream()
				.map(animal -> AnimalResponseModel.builder()
						.name(animal.getName())
						.species(animal.getSpecies())
						.breed(animal.getBreed())
						.gender(animal.getGender())
						.colour(animal.getColour())
						.dateOfBirth(animal.getDateOfBirth())
						.build())
				.toList();
	}

	@Override
	public List<AnimalResponseModel> findByCustomerId(Long customerId) {
		return animalRepository.findByCustomerId(customerId).stream()
				.map(animal -> AnimalResponseModel.builder()
						.name(animal.getName())
						.species(animal.getSpecies())
						.breed(animal.getBreed())
						.gender(animal.getGender())
						.colour(animal.getColour())
						.dateOfBirth(animal.getDateOfBirth())
						.build())
				.toList();
	}
}
