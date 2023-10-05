package com.example.Service;

import java.util.List;

import com.example.Entity.Doctor;

public interface DoctorService {
	
	public Doctor addDoctor(Doctor d);

	public List<Doctor> getAllDoctors();

	public Doctor getDoctorById(int id) ;

	public String deleteDoctor(int id);

	public Doctor updateDoctor(Doctor d);

}
