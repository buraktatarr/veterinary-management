package com.veterinary_management.service.impl;

import com.veterinary_management.core.dto.requests.AvailableDateCreateRequest;
import com.veterinary_management.core.dto.requests.AvailableDateUpdateRequest;
import com.veterinary_management.core.dto.responses.AvailableDateResponseModel;
import com.veterinary_management.entity.AvailableDate;
import com.veterinary_management.entity.Doctor;
import com.veterinary_management.repository.AvailableDateRepository;
import com.veterinary_management.repository.DoctorRepository;
import com.veterinary_management.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateServiceImpl implements AvailableDateService {
	private final AvailableDateRepository availableDateRepository;
	private final DoctorRepository        doctorRepository;

	@Override
	public void save(AvailableDateCreateRequest request) {
		Doctor doctor = doctorRepository.findById(request.doctorId())
				.orElseThrow(() -> new RuntimeException("Doktor bulunamadı."));
		boolean exists = availableDateRepository.existsByDoctorIdAndAvailableDate(request.doctorId(), request.availableDate());
		if (exists) {
			throw new RuntimeException("Doktor için bu tarihte zaten müsaitlik mevcut.");
		}
		AvailableDate availableDate = AvailableDate.builder()
				.doctor(doctor)
				.availableDate(request.availableDate())
				.build();
		availableDateRepository.save(availableDate);
	}

	@Override
	public void update(AvailableDateUpdateRequest request) {
		AvailableDate availableDate = availableDateRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Müsait gün bulunamadı."));
		Doctor doctor = doctorRepository.findById(request.doctorId())
				.orElseThrow(() -> new RuntimeException("Doktor bulunamadı."));
		availableDate.setDoctor(doctor);
		availableDate.setAvailableDate(request.availableDate());
		availableDateRepository.save(availableDate);
	}

	@Override
	public void deleteById(Long id) {
		availableDateRepository.deleteById(id);
	}

	@Override
	public List<AvailableDateResponseModel> findByDoctorId(Long doctorId) {
		return availableDateRepository.findByDoctorId(doctorId)
				.stream()
				.map(ad -> AvailableDateResponseModel.builder()
						.id(ad.getId())
						.doctorId(ad.getDoctor().getId())
						.availableDate(ad.getAvailableDate())
						.build())
				.toList();
	}
}
