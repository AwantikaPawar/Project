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
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Vid;
	@NotEmpty(message = "Date can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper date")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
	private String VDate;
	@NotEmpty(message = "Time can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper Time")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
	private String VTime;
	@NotEmpty(message = "Reason can't be empty!")
	@Size(min = 3, max = 25, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Accepts only alphabets! re-enter the Status")
	private String Reason_for_visit;
	@NotEmpty(message = "Diagnosis can't be empty!")
	@Size(min = 3, max = 50, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Accepts only alphabets! re-enter the Dignosis")
	private String Diagnosis;
	
	@NotEmpty(message = "Treatment can't be empty!")
	@Size(min = 3, max = 50, message = "Please enter proper data")
	@Column(length = 30)
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Accepts only alphabets! re-enter the Treatment")
	private String Treatment;
	private int doc_id;
	private int patient_id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(name = "dr_visit", joinColumns = @JoinColumn(name = "d_id"), inverseJoinColumns = @JoinColumn(name = "v_id"))
	Doctor dr;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
   
	@JoinTable(name = "patient_app", joinColumns = @JoinColumn(name = "p_id"), inverseJoinColumns = @JoinColumn(name = "v_id"))
	Patient patient;

}
