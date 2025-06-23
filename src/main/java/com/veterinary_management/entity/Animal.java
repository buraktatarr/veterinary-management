package com.veterinary_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long              id;
	private String            name;
	private String            species;
	private String            breed;
	private String            gender;
	private String            colour;
	private LocalDate         dateOfBirth;


	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer          customer;
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vaccine>     vaccines     = new ArrayList<>();
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> appointments = new ArrayList<>();
}
