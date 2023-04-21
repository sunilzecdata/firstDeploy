package com.example.demo.serviceimpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.RecruiterDao;
import com.example.demo.entity.Recruiter;
import com.example.demo.entity.Seeker;
import com.example.demo.service.RecruiterService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RecruiterServiceImpl implements RecruiterService{

	@Autowired
	RecruiterDao recruiterDao;
	
	@Override
	public Recruiter addRecruiter(Recruiter recruiter) {
		if(recruiter.getfName().isEmpty())
		{
			throw new NullPointerException(); 
		}
		return recruiterDao.save(recruiter);
	}
	

	@Override
	public String deleteRecruiter(UUID uuid) {
		Optional<Recruiter> recruiter= recruiterDao.findById(uuid);
		if(recruiter.isEmpty())
		{
			throw new EntityNotFoundException();
		}
		else {
		recruiterDao.deleteById(uuid);
		return "Successfully deleted";
		}
		
	}
	

}
