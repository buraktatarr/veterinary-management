package com.veterinary_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long      id;

	private LocalDate availableDate;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
}
