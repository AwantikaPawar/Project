package com.example.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Doctor;
import com.example.Entity.Patient;
import com.example.Entity.Visit;
import com.example.Repository.DoctorRepository;
import com.example.Repository.PatientRepository;
import com.example.Repository.VisitRepository;
import com.example.Service.VisitService;

@Service
public class VisitServiceImpl implements VisitService {
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	
	VisitRepository visitRepository;
	@Override
	public Visit addVisit(Visit v) {
		// TODO Auto-generated method stub
		Doctor _dr=doctorRepository.findById(v.getDoc_id()).get();
		v.setDr(_dr);
		Patient _p =patientRepository.findById(v.getPatient_id()).get();
		v.setPatient(_p);
		
		return visitRepository.save(v);
	}

	@Override
	public List<Visit> getAllVisits() {
		// TODO Auto-generated method stub
		return visitRepository.findAll();
	}

	@Override
	public Visit getVisitById(int id) {
		// TODO Auto-generated method stub
		return visitRepository.findById(id).get();
	}

	@Override
	public String deleteVisit(int id) {
		// TODO Auto-generated method stub
		visitRepository.deleteById(id);
		return "Visit deleted";
	}

	@Override
	public Visit updateVisit(Visit v) {
		// TODO Auto-generated method stub
		Visit _v=visitRepository.findById(v.getVid()).get();
		_v.setVTime(v.getVTime());
		_v.setVDate(v.getVDate());
		_v.setReason_for_visit(v.getReason_for_visit());
		_v.setDiagnosis(v.getDiagnosis());
		_v.setTreatment(v.getTreatment());
		return visitRepository.save(v);
	}
	
	
	

}
