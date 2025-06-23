package com.veterinary_management.repository;

import com.veterinary_management.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
	boolean existsByDoctorIdAndAvailableDate(Long id, LocalDate availableDate);

	List<AvailableDate> findByDoctorId(Long doctorId);
}
