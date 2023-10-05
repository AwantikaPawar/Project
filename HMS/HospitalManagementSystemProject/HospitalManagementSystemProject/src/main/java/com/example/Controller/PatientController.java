package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Patient;
import com.example.Service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;
	@PostMapping("/patient")
	public ResponseEntity<Object> addPatient(@RequestBody @Valid Patient p)
	{
		Patient pat=patientService.addPatient(p);
		return new ResponseEntity<Object>(pat, HttpStatus.OK);
	}
	
	@GetMapping("/patient")
	public List<Patient> getAllPatient()
	{
		return patientService.getAllPatients();
	}
	
	@GetMapping("/patient/{id}")
	public Patient getPatientById(@PathVariable int id)
	{
		return patientService.getPatientById(id);
	}
	
	@DeleteMapping("/patient/{id}")
	public String deletePatient(@PathVariable int id)
	{
		return patientService.deletePatient(id);
	}
	
	@PutMapping("/patient")
	public Patient updatePatient(@RequestBody Patient p)
	{
		return patientService.updatePatient(p);
	}
	
	
}
