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

import com.example.Entity.Doctor;
import com.example.Service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/doctor")
	//public Doctor addDoctor(@RequestBody @Valid Doctor d)
	public ResponseEntity<Object> addDoctor(@RequestBody @Valid Doctor d)
	{
		Doctor doc=doctorService.addDoctor(d);
		return new ResponseEntity<Object>(doc, HttpStatus.OK);
		}
	
	@GetMapping("/doctor")
	public List<Doctor> getAllDoctor()
	{
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/doctor/{id}")
	public Doctor getDoctorById(@PathVariable int id)
	{
		return doctorService.getDoctorById(id);
	}
	
	@DeleteMapping("/doctor/{id}")
	public String deleteDoctor(@PathVariable int id)
	{
		return doctorService.deleteDoctor(id);
	}
	
	@PutMapping("/doctor")
	public Doctor updateDoctor(@RequestBody Doctor d)
	{
		return doctorService.updateDoctor(d);
	}

}
