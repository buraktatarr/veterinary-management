package com.veterinary_management.api;

import com.veterinary_management.core.dto.requests.AvailableDateCreateRequest;
import com.veterinary_management.core.dto.requests.AvailableDateUpdateRequest;
import com.veterinary_management.core.dto.responses.AvailableDateResponseModel;
import com.veterinary_management.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/available-dates")
public class AvailableDatesApi {
	private final AvailableDateService availableDateService;

	@PostMapping
	public ResponseEntity<Void> createAvailableDate(@RequestBody AvailableDateCreateRequest request) {
		availableDateService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> updateAvailableDate(@RequestBody AvailableDateUpdateRequest request) {
		availableDateService.update(request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAvailableDate(@PathVariable Long id) {
		availableDateService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<AvailableDateResponseModel>> getAvailableDatesByDoctor(@PathVariable Long doctorId) {
		return ResponseEntity.ok(availableDateService.findByDoctorId(doctorId));
	}
}
