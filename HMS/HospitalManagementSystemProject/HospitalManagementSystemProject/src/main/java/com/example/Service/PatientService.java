package com.example.Service;

import java.util.List;

import com.example.Entity.Patient;

public interface PatientService {
	
	public Patient addPatient(Patient p) ;

	public List<Patient> getAllPatients();

	public Patient getPatientById(int id) ;

	public String deletePatient(int id);

	public Patient updatePatient(Patient p);

}
