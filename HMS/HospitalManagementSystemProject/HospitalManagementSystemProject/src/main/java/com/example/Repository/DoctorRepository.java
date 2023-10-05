package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
