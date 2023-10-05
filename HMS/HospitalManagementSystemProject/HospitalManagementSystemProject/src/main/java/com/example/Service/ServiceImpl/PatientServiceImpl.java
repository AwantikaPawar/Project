package com.example.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Patient;
import com.example.Repository.PatientRepository;
import com.example.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient p)  {
		// TODO Auto-generated method stub
	
			return patientRepository.save(p);
		
}
		
		

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).get();
	}

	@Override
	public String deletePatient(int id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
		return "Patient Deleted";
	}

	@Override
	public Patient updatePatient(Patient p) {
		// TODO Auto-generated method stub
		Patient _p=patientRepository.findById(p.getPid()).get();
		_p.setPname(p.getPname());
		_p.setContact(p.getContact());
		_p.setMedical_History(p.getMedical_History());
		return patientRepository.save(p);
	}
	
	

}
