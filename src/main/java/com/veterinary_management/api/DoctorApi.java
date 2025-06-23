package com.veterinary_management.api;

import com.veterinary_management.core.dto.requests.DoctorCreateRequest;
import com.veterinary_management.core.dto.requests.DoctorUpdateRequest;
import com.veterinary_management.core.dto.responses.DoctorResponseModel;
import com.veterinary_management.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorApi {
	private final DoctorService doctorService;

	@PostMapping
	public ResponseEntity<Void> createDoctor(@RequestBody DoctorCreateRequest request) {
		doctorService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> updateDoctor(@RequestBody DoctorUpdateRequest request) {
		doctorService.update(request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
		doctorService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<DoctorResponseModel>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DoctorResponseModel> getDoctorById(@PathVariable Long id) {
		return ResponseEntity.ok(doctorService.findById(id));
	}
}

