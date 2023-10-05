package com.example.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DId;
	@NotEmpty(message = "Name can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper name")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Accepts only alphabets! re-enter the Name")
	private String Dname;
	@NotEmpty(message = "Specialization can't be empty!")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! ")
	private String Specialization;
	@Pattern( regexp="^[A-Za-z0-9+_.-]+@(.+)$",message = "Email is not valid")
	@NotEmpty(message = "Email cannot be empty")
	@Column(unique = true, length = 30)
	private String Email;
	@NotEmpty(message = "Availibility can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$",message="Please enter proper data")
	private String Availibility;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dr")
	@JsonIgnore
	List<Visit> visits;
	@OneToMany(mappedBy = "dr")

	@JsonIgnore
	List<Appointment> appointments;

}
