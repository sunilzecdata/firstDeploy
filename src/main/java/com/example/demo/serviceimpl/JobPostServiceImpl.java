package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobPostDao;
import com.example.demo.entity.JobPost;
import com.example.demo.entity.Seeker;
import com.example.demo.service.JobPostService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JobPostServiceImpl implements JobPostService {

	
	@Autowired
	JobPostDao jobPostServiceDao;
	
	@Override
	public JobPost jobPostAdd(JobPost jobPost) {
		if(jobPost.getTitle().isEmpty())
		{
			throw new NullPointerException();
		}
		JobPost jobPost1=jobPostServiceDao.save(jobPost);
		return jobPost1;
	}

	@Override
	public String jobPostDeleteById(UUID uuid) {
		Optional<JobPost> jobPost=jobPostServiceDao.findById(uuid);
		if(jobPost.isEmpty())
		{
			throw new EntityNotFoundException();
		}
		jobPostServiceDao.deleteById(uuid);
		return "Successfully Deleted";
		
	}

	@Override
	public List<JobPost> showJobPost() {
	    List<JobPost> postJobList=jobPostServiceDao.findAll();
	    if(postJobList.isEmpty())
	    {
	    	throw new EntityNotFoundException();
	    }
	     return jobPostServiceDao.findAll();
	    
	}

	@Override
	public Optional<JobPost> JobPostGetById(UUID uuid) {
		Optional<JobPost> jobPost=jobPostServiceDao.findById(uuid);
		if(jobPost.isEmpty())
		{
			throw new EntityNotFoundException();
		}
	     return jobPost;
	}
	
}


