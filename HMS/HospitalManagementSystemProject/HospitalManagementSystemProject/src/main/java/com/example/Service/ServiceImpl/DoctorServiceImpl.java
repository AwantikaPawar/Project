package com.example.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Doctor;
import com.example.Repository.DoctorRepository;
import com.example.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return doctorRepository.save(d);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).get();
	}

	@Override
	public String deleteDoctor(int id) {
		// TODO Auto-generated method stub
		 doctorRepository.deleteById(id);
		 return "Doctor Deleted";
	}

	@Override
	public Doctor updateDoctor(Doctor d) {
		// TODO Auto-generated method stub
		Doctor _d = doctorRepository.findById(d.getDId()).get();
		_d.setDname(d.getDname());
		_d.setEmail(d.getEmail());
		_d.setSpecialization(d.getSpecialization());
		_d.setAvailibility(d.getAvailibility());
		return doctorRepository.save(d);
	}
	
	

}
