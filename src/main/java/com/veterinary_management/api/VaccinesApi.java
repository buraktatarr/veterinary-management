package com.veterinary_management.api;

import com.veterinary_management.core.dto.requests.VaccineCreateRequest;
import com.veterinary_management.core.dto.requests.VaccineUpdateRequest;
import com.veterinary_management.core.dto.responses.VaccineResponseModel;
import com.veterinary_management.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vaccine")
public class VaccinesApi {
	private final VaccineService vaccineService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody VaccineCreateRequest request) {
		vaccineService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody VaccineUpdateRequest request) {
		vaccineService.save(request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		vaccineService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<VaccineResponseModel>> findAll() {
		return ResponseEntity.ok(vaccineService.findAll());
	}

	@GetMapping("/animal/{animalId}")
	public ResponseEntity<List<VaccineResponseModel>> findByAnimalId(@PathVariable Long animalId) {
		return ResponseEntity.ok(vaccineService.findByAnimalId(animalId));
	}

	@GetMapping("/expiring")
	public ResponseEntity<List<VaccineResponseModel>> getExpiringVaccines(
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
			@RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
		return ResponseEntity.ok(vaccineService.findVaccinesExpiringBetween(start, end));
	}
}
