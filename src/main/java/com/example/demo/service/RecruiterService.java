package com.example.demo.service;

import java.util.UUID;

import com.example.demo.entity.Recruiter;

public interface RecruiterService {
	
	//add recruiter
	public Recruiter addRecruiter(Recruiter recruiter);
	
	//Delete Recruiter
	public String deleteRecruiter(UUID uuid);

}
