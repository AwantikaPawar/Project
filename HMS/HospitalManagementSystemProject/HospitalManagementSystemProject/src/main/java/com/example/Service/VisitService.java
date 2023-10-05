package com.example.Service;

import java.util.List;

import com.example.Entity.Visit;

public interface VisitService {
	
	public Visit addVisit(Visit v);

	public List<Visit> getAllVisits();

	public Visit getVisitById(int id) ;

	public String deleteVisit(int id);

	public Visit updateVisit(Visit v);

}
