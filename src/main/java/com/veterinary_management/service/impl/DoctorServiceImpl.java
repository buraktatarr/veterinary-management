package com.veterinary_management.service.impl;

import com.veterinary_management.core.dto.requests.DoctorCreateRequest;
import com.veterinary_management.core.dto.requests.DoctorUpdateRequest;
import com.veterinary_management.core.dto.responses.AvailableDateResponseModel;
import com.veterinary_management.core.dto.responses.DoctorResponseModel;
import com.veterinary_management.entity.Doctor;
import com.veterinary_management.repository.DoctorRepository;
import com.veterinary_management.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
	private final DoctorRepository doctorRepository;

	@Override
	public void save(DoctorCreateRequest request) {
		Doctor doctor = Doctor.builder()
				.name(request.name())
				.phone(request.phone())
				.mail(request.mail())
				.address(request.address())
				.city(request.city())
				.build();
		doctorRepository.save(doctor);
	}

	@Override
	public void update(DoctorUpdateRequest request) {
		Doctor doctor = doctorRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Doktor bulunamadı"));
		doctor.setName(request.name());
		doctor.setPhone(request.phone());
		doctor.setMail(request.mail());
		doctor.setAddress(request.address());
		doctor.setCity(request.city());
		doctorRepository.save(doctor);
	}

	@Override
	public void delete(Long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public List<DoctorResponseModel> findAll() {
		List<Doctor> doctors = doctorRepository.findAll();
		return doctors.stream().map(doctor -> DoctorResponseModel.builder()
				.id(doctor.getId())
				.name(doctor.getName())
				.phone(doctor.getPhone())
				.mail(doctor.getMail())
				.address(doctor.getAddress())
				.city(doctor.getCity())
				.availableDates(
						doctor.getAvailableDates()
								.stream()
								.map(ad -> AvailableDateResponseModel.builder()
										.id(ad.getId())
										.doctorId(doctor.getId())
										.availableDate(ad.getAvailableDate())
										.build())
								.toList()
				)
				.build()
		).toList();
	}

	@Override
	public DoctorResponseModel findById(Long id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Doktor bulunamadı"));
		return DoctorResponseModel.builder()
				.id(doctor.getId())
				.name(doctor.getName())
				.phone(doctor.getPhone())
				.mail(doctor.getMail())
				.address(doctor.getAddress())
				.city(doctor.getCity())
				.availableDates(
						doctor.getAvailableDates()
								.stream()
								.map(ad -> AvailableDateResponseModel.builder()
										.id(ad.getId())
										.doctorId(doctor.getId())
										.availableDate(ad.getAvailableDate())
										.build())
								.toList()
				)
				.build();
	}
}
