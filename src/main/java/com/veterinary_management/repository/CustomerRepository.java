package com.veterinary_management.repository;

import com.veterinary_management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByNameContainingIgnoreCase(String name);
}
