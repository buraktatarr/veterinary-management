package com.veterinary_management.repository;

import com.veterinary_management.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	List<Animal> findByName(String name);
	List<Animal> findByCustomerId(Long customerId);
}
