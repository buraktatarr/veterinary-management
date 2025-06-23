package com.veterinary_management.api;

import com.veterinary_management.core.dto.requests.CustomerCreateRequest;
import com.veterinary_management.core.dto.requests.CustomerUpdateRequest;
import com.veterinary_management.core.dto.responses.CustomerResponseModel;
import com.veterinary_management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomersApi {
	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody CustomerCreateRequest request) {
		customerService.save(request);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody CustomerUpdateRequest request) {
		customerService.update(request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		customerService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponseModel>> findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("/by-name")
	public ResponseEntity<List<CustomerResponseModel>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(customerService.findByName(name));
	}
}
