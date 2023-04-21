package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RecruiterDao;
import com.example.demo.entity.Recruiter;
import com.example.demo.service.RecruiterService;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
	
	@Autowired
	RecruiterService recruiterService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Recruiter> recruiterAdd(@RequestBody Recruiter recruiter)
	{
		Recruiter saveRecruiter= recruiterService.addRecruiter(recruiter);
		return new ResponseEntity<Recruiter>(saveRecruiter, HttpStatus.CREATED);
			
	}
	
	@DeleteMapping("/delrecruiter/{uuid}")
	public ResponseEntity<?> deleteRecruiter(@PathVariable UUID uuid)
	{
	    String msg=recruiterService.deleteRecruiter(uuid);
	    return new ResponseEntity<String>(msg, HttpStatus.OK);
				
	}
	
	
}
