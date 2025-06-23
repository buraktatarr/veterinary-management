package com.veterinary_management.service.impl;

import com.veterinary_management.core.dto.requests.VaccineCreateRequest;
import com.veterinary_management.core.dto.requests.VaccineUpdateRequest;
import com.veterinary_management.core.dto.responses.AnimalResponseModel;
import com.veterinary_management.core.dto.responses.VaccineResponseModel;
import com.veterinary_management.entity.Animal;
import com.veterinary_management.entity.Vaccine;
import com.veterinary_management.repository.AnimalRepository;
import com.veterinary_management.repository.VaccineRepository;
import com.veterinary_management.service.VaccineService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {
	private final VaccineRepository vaccineRepository;
	private final AnimalRepository  animalRepository;

	@Override
	public void save(VaccineCreateRequest request) {
		boolean exists = vaccineRepository.existsByAnimalIdAndNameAndCodeAndProtectionFinishDateAfter(
				request.animalId(),
				request.name(),
				request.code(),
				LocalDate.now()
		);
		if (exists) {
			throw new RuntimeException("Hayvan için bu aşı zaten aktif durumda. Koruyuculuk süresi henüz dolmamış.");
		}
		Animal animal = animalRepository.findById(request.animalId())
				.orElseThrow(() -> new EntityNotFoundException("Animal not found with ID: " + request.animalId()));
		Vaccine vaccine = Vaccine.builder()
				.name(request.name())
				.code(request.code())
				.protectionStartDate(request.protectionStartDate())
				.protectionFinishDate(request.protectionFinishDate())
				.animal(animal)
				.build();
		vaccineRepository.save(vaccine);
	}

	@Override
	public void save(VaccineUpdateRequest request) {
		Vaccine vaccine = vaccineRepository.findById(request.id())
				.orElseThrow(() -> new EntityNotFoundException("Not found vaccine for: id=" + request.id()));
		vaccine.setName(request.name());
		vaccine.setCode(request.code());
		vaccine.setProtectionStartDate(request.protectionStartDate());
		vaccine.setProtectionFinishDate(request.protectionFinishDate());
		vaccineRepository.save(vaccine);
	}

	@Override
	public void deleteById(Long id) {
		vaccineRepository.deleteById(id);
	}

	@Override
	public List<VaccineResponseModel> findAll() {
		return vaccineRepository.findAll().stream().map(vaccine -> VaccineResponseModel.builder()
				.name(vaccine.getName())
				.code(vaccine.getCode())
				.protectionStartDate(vaccine.getProtectionStartDate())
				.protectionFinishDate(vaccine.getProtectionFinishDate())
				.animal(AnimalResponseModel.builder()
						.name(vaccine.getAnimal().getName())
						.gender(vaccine.getAnimal().getGender())
						.species(vaccine.getAnimal().getSpecies())
						.breed(vaccine.getAnimal().getBreed())
						.colour(vaccine.getAnimal().getColour())
						.dateOfBirth(vaccine.getAnimal().getDateOfBirth())
						.build())
				.build()
		).toList();
	}

	@Override
	public List<VaccineResponseModel> findByAnimalId(Long animalId) {
		return vaccineRepository.findByAnimalId(animalId).stream().map(vaccine -> VaccineResponseModel.builder()
				.name(vaccine.getName())
				.code(vaccine.getCode())
				.protectionStartDate(vaccine.getProtectionStartDate())
				.protectionFinishDate(vaccine.getProtectionFinishDate())
				.animal(AnimalResponseModel.builder()
						.name(vaccine.getAnimal().getName())
						.gender(vaccine.getAnimal().getGender())
						.species(vaccine.getAnimal().getSpecies())
						.breed(vaccine.getAnimal().getBreed())
						.colour(vaccine.getAnimal().getColour())
						.dateOfBirth(vaccine.getAnimal().getDateOfBirth())
						.build())
				.build()
		).toList();
	}

	@Override
	public List<VaccineResponseModel> findVaccinesExpiringBetween(LocalDate start, LocalDate end) {
		List<Vaccine> vaccines = vaccineRepository.findByProtectionFinishDateBetween(start, end);
		return vaccines.stream().map(vaccine -> {
			Animal animal = vaccine.getAnimal();
			return VaccineResponseModel.builder()
					.name(vaccine.getName())
					.code(vaccine.getCode())
					.protectionStartDate(vaccine.getProtectionStartDate())
					.protectionFinishDate(vaccine.getProtectionFinishDate())
					.animal(AnimalResponseModel.builder()
							.name(animal.getName())
							.species(animal.getSpecies())
							.breed(animal.getBreed())
							.gender(animal.getGender())
							.colour(animal.getColour())
							.dateOfBirth(animal.getDateOfBirth())
							.build())
					.build();
		}).toList();
	}
}
