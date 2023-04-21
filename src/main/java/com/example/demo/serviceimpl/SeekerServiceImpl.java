package com.example.demo.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.custom.exception.BusinessException;
import com.example.demo.dao.SeekerDao;
import com.example.demo.entity.Seeker;
import com.example.demo.service.SeekerService;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SeekerServiceImpl implements SeekerService {

	@Autowired
	SeekerDao seekerDao;

	@Override
	public Seeker seekerAdd(Seeker seeker) {
		
		//try {
			Seeker seekerReturn = seekerDao.save(seeker);
		if (StringUtils.isBlank(seekerReturn.getName())) {
			throw new BusinessException();
			}
		return seekerReturn;
//		}
//		catch(BusinessException e)
//		{
//		   throw new BusinessException("pls fullfill name field");	
//		}
//		
//			catch (IllegalArgumentException e) {
//			    throw new BusinessException(" whole entity is empty  "+e.getMessage());
//			}
//		
//		    catch (Exception e) {
//			throw new BusinessException("something went wrong 2 ");
//		}		
	}
  
	
	@Override
	public Seeker seekerGetById(Integer id) {
		try {
		Optional<Seeker> seeker = seekerDao.findById(id);
		if(seeker.isPresent())
		{
          return seeker.get();
		}
		throw new BusinessException();
		}
		
//		catch(IllegalArgumentException e)
//		{
//			throw new BusinessException("901","pls put valid arguments in the block"+e.getMessage());
//		}
		catch(NoSuchElementException e)
		{
			throw new BusinessException("No any object is present ");
		}
		catch(Exception e)
		{
			throw new BusinessException("500 something went wrong in buissnes layer");
		}
		
	}
	

	

	@Override
	public List<Seeker> showSeeker() {
		
		List<Seeker> seekerList = seekerDao.findAll();
		return seekerList;
		
	}


	@Override
	public Seeker getByEmail(String email) {
		List<Seeker> list=showSeeker();
		for(Seeker li: list)
		{
			if(li.getEmail().equals(email))
			{
				return li;
			}
		}
		return null;
	}
	
	
	
	
//	
//	@Override
//	public String seekerDeleteById(Integer id) {
//		try {
//		Optional<Seeker> seeker = seekerDao.findById(id);
//		if (seeker.isPresent()) {
//			seekerDao.deleteById(id);
//		}
//		return "Successfully Deleted";
//		}
//		catch(NoSuchElementException e){
//			throw new BusinessException("204","NO Seeker Found on this Id");
//		}
//		catch(IllegalArgumentException e)
//		{
//			throw new BusinessException("402","pls input right element");
//		}
//		catch(Exception e)
//		{
//			throw new BusinessException("500","Something went wrong");
//		}
//
//	}
	
	public Seeker updateSeeker(int id, String name, String role)	{
		
		Optional<Seeker> seeker= seekerDao.findById(id);
		
		if(seeker.isPresent())
		{
			Seeker seeker1=seeker.get();
			seeker1.setName(name);
			seeker1.setRole(role);
			return seekerDao.save(seeker1);
		}
		return null;		
	}

}
