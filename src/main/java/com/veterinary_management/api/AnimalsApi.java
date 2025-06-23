package com.veterinary_management.api;

import com.veterinary_management.core.dto.requests.AnimalCreateRequest;
import com.veterinary_management.core.dto.requests.AnimalUpdateRequest;
import com.veterinary_management.core.dto.responses.AnimalResponseModel;
import com.veterinary_management.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/animal")
public class AnimalsApi {
	private final AnimalService service;


	@PostMapping
	public ResponseEntity<Void> save(@RequestBody AnimalCreateRequest request) {
		service.save(request);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody AnimalUpdateRequest request) {
		service.update(request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<AnimalResponseModel>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/by-name")
	public ResponseEntity<List<AnimalResponseModel>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(service.findByName(name));
	}

	@GetMapping("/by-customer/{customerId}")
	public ResponseEntity<List<AnimalResponseModel>> findByCustomer(@PathVariable Long customerId) {
		return ResponseEntity.ok(service.findByCustomerId(customerId));
	}
}
