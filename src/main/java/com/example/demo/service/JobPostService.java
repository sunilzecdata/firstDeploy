package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.entity.JobPost;
import com.example.demo.entity.Seeker;

public interface JobPostService {
	
	 //add JobPost 
	public JobPost jobPostAdd(JobPost jobpost);
	
	//Delete JobPost 
	public String jobPostDeleteById(UUID uuid);
	
	//get Seeker
	public List<JobPost > showJobPost ();
	
	//get by id Seeker
	public Optional<JobPost > JobPostGetById(UUID uuid);

}
