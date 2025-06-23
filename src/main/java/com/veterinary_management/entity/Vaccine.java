package com.veterinary_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long      id;
	private String    name;
	private String    code;
	private LocalDate protectionStartDate;
	private LocalDate protectionFinishDate;
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal    animal;
}
