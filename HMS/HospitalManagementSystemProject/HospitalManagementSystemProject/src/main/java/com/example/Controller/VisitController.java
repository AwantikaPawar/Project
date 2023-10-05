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

import com.example.Entity.Visit;
import com.example.Service.VisitService;

@RestController
public class VisitController {
	@Autowired
	   VisitService visitService;

	   @PostMapping("/visit")
	   public ResponseEntity <Object> addVisit(@RequestBody @Valid Visit v)
	   {
		   Visit vi=visitService.addVisit(v);
		   return new ResponseEntity<Object>(vi,HttpStatus.OK);
	   }

	    @GetMapping("/visit")
	    public List<Visit> getAllVisit()
	    {
	    	return visitService.getAllVisits();
	    }
	    
	    @GetMapping("/visit/{id}")
	    public Visit getVisitById(@PathVariable int id)
	    {
	    	return visitService.getVisitById(id);
	    }
	    
	    @DeleteMapping("/visit/{id}")
	    public String deleteVisit(@PathVariable int id)
	    {
	    	return visitService.deleteVisit(id);
	    }
	    
	    @PutMapping("/visit")
	    public Visit updateVisit(@RequestBody Visit v)
	    {
	    	return visitService.updateVisit(v);
	    }
}
