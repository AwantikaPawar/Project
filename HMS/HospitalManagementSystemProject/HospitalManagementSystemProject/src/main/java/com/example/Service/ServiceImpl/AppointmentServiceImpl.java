package com.example.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Appointment;
import com.example.Entity.Doctor;
import com.example.Entity.Patient;
import com.example.Repository.AppointmentRepository;
import com.example.Repository.DoctorRepository;
import com.example.Repository.PatientRepository;
import com.example.Service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
 
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;

	@Override
	public Appointment addAppointment(Appointment ap) {
		// TODO Auto-generated method stub
		Doctor _dr=doctorRepository.findById(ap.getDoc_id()).get();
		ap.setDr(_dr);
		Patient _p =patientRepository.findById(ap.getPatient_id()).get();
		ap.setPatient(_p);
		
		return appointmentRepository.save(ap);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id).get();
	}

	@Override
	public String deleteAppointment(int id) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(id);
		return "Appointment Deleted";
	}

	@Override
	public Appointment updateAppointment(Appointment ap) {
		// TODO Auto-generated method stub
		Appointment _ap =appointmentRepository.findById(ap.getAid()).get();
		_ap.setADate(ap.getADate());
		_ap.setATime(ap.getATime());
		_ap.setStatus(ap.getStatus());
		return appointmentRepository.save(ap);
	}
	
	
}
