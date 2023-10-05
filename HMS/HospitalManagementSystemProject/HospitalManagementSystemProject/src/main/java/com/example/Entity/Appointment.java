package com.example.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Aid;
	
	@NotEmpty(message = "Date can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
	private String ADate;
	@NotEmpty(message = "Time can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
	private String ATime;
	@NotEmpty(message = "Status can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Accepts only alphabets! re-enter the Status")
	private String Status;
	private int doc_id;
	private int patient_id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	 @JsonIgnore
	@JoinTable(name = "dr_app", joinColumns = @JoinColumn(name = "d_id"), inverseJoinColumns = @JoinColumn(name = "a_id"))
	Doctor dr;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(name = "patient_app", joinColumns = @JoinColumn(name = "p_id"), inverseJoinColumns = @JoinColumn(name = "a_id"))
	Patient patient;

}
